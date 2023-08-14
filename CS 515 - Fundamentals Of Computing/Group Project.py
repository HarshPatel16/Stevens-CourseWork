# Harsh Patel               CWID: 20005159
# Ritwik Gurrala            CWID: 20006750
# Vivek Sharma Ponnekanti   CWID: 20009404
'''Pledge: I pledge my honor that I have abided by the Stevens Honor System'''


import os.path
import operator

PREF_FILE = 'musicrecplus.txt'

def update_artist_counts(artist_l_l):
    '''Return new entered artists by user and adds it in file'''
    a_to_c = {}
    for artist_list in artist_l_l:
        for artist in artist_list:
            if artist in a_to_c:
                a_to_c[artist] += 1
            else:
                a_to_c[artist]=1
    return a_to_c

def loadUsers (fileName) :
    '''Returns the dictionary with users list and their preferred artist in array from file given as input
        input fileName: string'''
    if os.path.exists(fileName) == False:
        file = open(fileName,'a+')
    else:
        file = open(fileName,'r')
    userDict = {}
    count_artists={}
    artist_to_count={}
    artist_l_l=[]
    for line in file:
        [userName, artists] = line.strip().split(':')
        artist_list = artists.split(',')
        artist_list=[each_string.title() for each_string in artist_list]
        count_artists[userName]=len(artist_list)
        artist_list.sort()
        userDict[userName] = artist_list
        if userName[-1] != '$':
            artist_l_l.append(artist_list)
    artist_to_count=update_artist_counts(artist_l_l)
    file.close ()
    return userDict,count_artists,artist_to_count

def initial_preferences(userName,userMap):
    '''Takes artist name intially from user and adds it in file and appends name and return list'''
    prefs = []
    newPref = input ("Enter an artist that you like(Enter to finish):\n")
    while newPref!= "":
        prefs.append (newPref.strip().title())
        newPref = input ("Enter an artist that you like(Enter to finish):\n")
    prefs2=sorted(prefs)
    return prefs2

def enter_preferences(userName,userMap):
    '''Takes artist name and appends new name to the list and returns list of artists'''
    newPref = ""
    if userName in userMap:
        prefs = userMap[userName]
        newPref = input ("Enter an artist that you like(Enter to finish):\n")
    else:
        prefs = []
        newPref = input ("Enter an artist that you like(Enter to finish):\n")
    while newPref!= '':
        prefs.append (newPref.strip().title())
        newPref = input ("Enter an artist that you like(Enter to finish):\n")
    prefs.sort()
    return prefs

def get_recommendations(currUser, prefs, userMap):
    '''Returns Recommendation list of artists to the user'''
    if len(userMap)<=1:
        return []
    bestUser = findBestUser (currUser, prefs, userMap)
    recommendations = drop(prefs, userMap[bestUser])
    return sorted(list(set(recommendations)))

def findBestUser (currUser, prefs, userMap):
    ''' Find the user whose tastes are closest to the current
    user. Return the best user's name (a string)
    '''
    bestUser = None
    bestScore = -1
    for user in userMap.keys():
        if(all(x in prefs for x in userMap[user])) or (user[-1]=="$"):continue
        score = numMatches(prefs, userMap[user])
        if score > bestScore and currUser!= user:
            bestScore = score
            bestUser = user
    return bestUser

def drop ( list1, list2 ):
    ''' Return a new list that contains only the elements in
    list2 that were NOT in list1. '''
    list3 = []
    i = 0
    j = 0
    while i < len (list1) and j < len (list2):
        if list1[i] == list2[j]:
            i+=1
            j+=1
        elif list1[i] < list2[j]:
            i+=1
        else:
            list3.append(list2[j])
            j+=1
    while j < len (list2) :
        list3. append (list2[j])
        j+=1
    return list3

def numMatches( list1, list2 ):
    '''return the number of elements that match between
    two sorted lists'''
    matches = 0
    i = 0
    j = 0
    while i < len (list1) and j < len (list2):
        if list1[i] == list2[j]:
            matches += 1
            i += 1
            j += 1
        elif list1[i] < list2[j]:
            i += 1
        else:
            j += 1
    return matches

def most_popular_artist(artist_to_count):
    '''Returns artists which is in most users reference'''
    lst=[]
    max_count=max(artist_to_count,key=lambda x:artist_to_count[x])
    if max_count=="":
        print("Sorry , no artists found .")
    else:
        for k,v in artist_to_count.items():
            if v==artist_to_count[max_count]:
                lst.append(k)
    return lst

def most_popular_count(artist_to_count):
    '''Returns most popular artist occurunce count'''
    s_list=most_popular_artist(artist_to_count)
    artist_name=s_list[0]
    if artist_name=="" :
        print("Sorry , no artists found .")
    else:
        print(artist_to_count[artist_name])

def users_with_most_likes(count_artists):
    '''Retuns user with who has referenced most artists'''
    count_artists1={}
    for k,v in count_artists.items():
        if k[-1]!="$":
            count_artists1[k]=v
    max_artists_count=max(count_artists1,key= lambda x:count_artists1[x])
    if max_artists_count=="":
        print("Sorry , no user found .")
    else:
        for k,v in count_artists1.items():
            if v==count_artists1[max_artists_count] and k[-1]!="$":
                print(k)

def save_file(userName, prefs, userMap, fileName):
    ''' Writes all of the user preferences to the file and closes the file.
    Returns nothing.
    '''
    userMap[userName] = prefs
    file = open (fileName, 'w')
    for user in userMap:
        toSave = str(user) + ':' + ','.join(userMap[user]) + '\n'
        file.write(toSave)
    file.close()

def get_current_user_preferences(userName,userMap):
    '''Prints the current artists user has'''
    if len(userMap[userName]) == 0:
         print("No artists to show")
    else:
        print("\n".join(userMap[userName]))

def delete_preferences(userName, userMap):
    '''Return updated list after deleting the preference that user entered'''
    delPref = ""
    if userName in userMap:
        prefs = userMap[userName]
        if len(prefs) == 0:
            print("No artists to delete")
            return prefs
        for i in range(len(prefs)):
            print(str(i+1)+". "+prefs[i])

        delPref = input(
            "Enter an artist index that you like to delete(Enter to finish):\n")
        print("\n")
    else:
        print("User does not exists")
        return
    while delPref != '':

        if delPref.isdigit() == False:
            print("\n")
            delPref = input(
                "Please enter a valid value given above(Enter to finish):\n")
        delPref = int(delPref)
        if delPref > len(prefs):
            print("\n\n")
            delPref = input(
                "Please enter a valid value given above(Enter to finish):\n")
        else:
            prefs.pop(delPref-1)
            if len(prefs) == 0:
                print("No artists to delete")
                break
            for i in range(len(prefs)):
                print(str(i+1)+". "+prefs[i])
            delPref = input(
                "Enter an artist number that you like to delete(Enter to finish):\n")
            print("\n")

    return prefs

def menu():
    '''Shows option menu to the user'''
    print("""Enter a letter to choose an option:
    e - Enter preferences
    r - Get recommendations
    p - Show most popular artists
    h - How popular is the most popular
    m - Which user has the most likes
    s - For current user preferences
    d - To delete any preference
    q - Save and quit""")
    choice=input()
    return choice

if __name__=='__main__':

    userMap,count_artists,artist_to_count = loadUsers (PREF_FILE)
    userName = input ("Enter your name (put a $ symbol after your name if you wish your preferences to remain private): \n")
    if userName=="":
        userName=input ("Enter your name (put a $ symbol after your name if you wish your preferences to remain private): \n")
    if userName not in userMap:
        prefs=initial_preferences(userName,userMap)
        save_file(userName,prefs,userMap,PREF_FILE)
        userMap,count_artists,artist_to_count = loadUsers (PREF_FILE)
    pr=userMap[userName]
    while(1):
        choices=["e","r","p","h","m","s","d","q"]
        choice=menu()
        if choice not in choices:
            choice=menu()
        elif choice=="e":
            p=enter_preferences(userName,userMap)
            save_file(userName,p,userMap,PREF_FILE)
            userMap,count_artists,artist_to_count = loadUsers (PREF_FILE)
        elif choice=="r":
            recommendations=get_recommendations(userName,pr,userMap)
            if len(recommendations)==0:
                print("No recommendations available at this time.")
            else:
                print("\n".join(recommendations))
        elif choice=="p":
            s_list=most_popular_artist(artist_to_count)
            print("\n".join(s_list))
        elif choice=="h":
            most_popular_count(artist_to_count)
        elif choice=="m":
            save_file(userName,pr,userMap,PREF_FILE)
            users_with_most_likes(count_artists)
        elif choice == "s":
            get_current_user_preferences(userName, userMap)
        elif choice == "d":
            pr = delete_preferences(userName, userMap)
            save_file(userName, pr, userMap, PREF_FILE)
            userMap, count_artists, artist_to_count = loadUsers(PREF_FILE)
        else:
            save_file(userName, pr, userMap, PREF_FILE)
            break
