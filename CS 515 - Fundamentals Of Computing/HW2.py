"""
Name- Harsh Maheshbhai Patel
CWID- 20005159
I pledge my honor that I have abided by the Stevens Honor System.
"""
from functools import reduce

scrabbleScores = [ ["a", 1], ["b", 3], ["c", 3], ["d", 2], ["e", 1],
["f", 4], ["g", 2], ["h", 4], ["i", 1], ["j", 8], ["k", 5], ["l", 1],
["m", 3], ["n", 1], ["o", 1], ["p", 3], ["q", 10], ["r", 1], ["s", 1],
["t", 1], ["u", 1], ["v", 4], ["w", 4], ["x", 8], ["y", 4], ["z", 10] ]

Dictionary = ["a", "am", "at", "apple", "bat", "bar", "babble", "can", "foo","harsh",
"spam", "spammy", "zzyzva"]
list=(["a","b","c"])

def letterScore(letter,scrabbleScores):
    """
    This function searches the scrabbleScores list and returns score according
    """
    if letter==scrabbleScores[0][0]:
        return scrabbleScores[0][1]
    else:
        return letterScore(letter, scrabbleScores[1:])

def wordScore(word, scrabbleScores):
    """
    This function seaches a letter by letter and sums the scrabbleScores
    of each letter
    """
    if len(word)==0:
        return 0
    else:
        return letterScore(word[0], scrabbleScores)+wordScore(word[1:], scrabbleScores)

def scoreList(Rack):
    """
    This function takes a list of letters and returns all the words and wordscore
    with letters from list in it
    """
    def calculate(dict, Rack):
        """
        this function calculates 
        """
        if dict == []:
            return []
        if buildWord(dict[0], Rack):
            return [[dict[0], wordScore(dict[0], scrabbleScores)]] + calculate(dict[1:], Rack)
        else:
            return calculate(dict[1:], Rack)
    return calculate(Dictionary, Rack)

def bestWord(Rack):
    """
    Takes a rack(list) as parameter andreturn bestword with bestscore that can
    be made from the list
    """
    def builder(list, word):
        """
        This function builds a word and wordscore which is has highest wordscore
        """
        if list == []:
            return word
        if list[0][1] >= word[1]:
            return builder(list[1:], list[0])
        else:
            return builder(list[1:], word)
    return builder(scoreList(Rack), ['', 0])

"""
 helper functions 
"""

def removeCharacter(letter, list):
    """
    This function takes a letter and removes it from the list and returns list
    """
    if list == []:
        return []
    if list[0] == letter:
        return list[1:]
    return [list[0]] + removeCharacter(letter, list[1:])


def buildWord(word, list):
    """
    checks if word's all characters are in list
    """

    if list == [] and len(word) > 0:
        return False
    elif len(word) == 0:
        return True
    elif word[0] in list:
        return buildWord(word[1:], removeCharacter(word[0], list))
    else:
        return False
      
