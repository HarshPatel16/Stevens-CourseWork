'''
Created on Apr 26 2022
@author:  Harsh Maheshbhai Patel
Pledge: I pledge my honor that I have abided by the Stevens Honor System
CS115 - Hw 12 - Date class
'''
DAYS_IN_MONTH = (0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
class Date(object):
    '''A user-defined data structure that stores and manipulates dates.'''
    # The constructor is always named __init__.
    def __init__(self, month, day, year):
        '''The constructor for objects of type Date.'''
        self.month = month
        self.day = day
        self.year = year
    # The 'printing' function is always named __str__.
    def __str__(self):
        '''This method returns a string representation for the
           object of type Date that calls it (named self).
             ** Note that this _can_ be called explicitly, but
                it more often is used implicitly via the print
                statement or simply by expressing self's value.'''
        return '%02d/%02d/%04d' % (self.month, self.day, self.year)
    def __repr__(self):
        '''This method also returns a string representation for the object.'''
        return self.__str__()
    # Here is an example of a 'method' of the Date class.
    def isLeapYear(self):
        '''Returns True if the calling object is in a leap year; False
        otherwise.'''
        if self.year % 400 == 0:
            return True
        if self.year % 100 == 0:
            return False
        if self.year % 4 == 0:
            return True
        return False

    def copy(self):
         '''Returns a new object with the same month, day, year
         as the calling object (self).'''
         dnew = Date(self.month, self.day, self.year)
         return dnew

    def equals(self, d2):
         '''Decides if self and d2 represent the same calendar date,
         whether or not they are the in the same place in memory.'''
         return self.year == d2.year and self.month == d2.month and \
         self.day == d2.day

    def tomorrow(self):
        '''Updates date to next date's date'''
        dnew = Date(self.month, self.day, self.year)
        if self.month==12 and self.day==31:
            self.month=1
            self.day=1
            self.year=self.year + 1

        elif self.month==2 and self.day==28 and dnew.isLeapYear()==True:
            self.day=self.day + 1

        elif self.day >= DAYS_IN_MONTH[self.month]:
            self.day = 1
            self.month = self.month + 1 
        
        else:
            self.day = self.day + 1

    def yesterday(self):
        '''updates date to yesterday's date'''
        dnew = Date(self.month, self.day, self.year)
        if self.month==1 and self.day==1:
            self.month=12
            self.day=31
            self.year=self.year - 1

        elif dnew.isLeapYear()==True and self.month==3 and self.day==1:
            self.day=29
            self.month= self.month-1

        elif self.day==1:
            self.day=DAYS_IN_MONTH[self.month-1]
            self.month=self.month - 1        

        else:
            self.day= self.day - 1 

    def addNDays(self, N):
        '''Adds N days and prints dates from self to the Nth day from self'''
        print(self)
        for i in range(N):
            self.tomorrow()
            print(self)

    def subNDays(self, N):
        '''Subtracts N days and prints dates from self to Nth day from self'''
        print(self)
        for i in range(N):
            self.yesterday()
            print(self)
    
    def isBefore(self, d2):
        '''Returns true if self date is before d2'''
        if self.equals(d2):
            return False
        elif self.year>d2.year:
            return False
        elif self.month>d2.month and self.year==d2.year:
            return False
        elif self.day>d2.day and self.month==d2.month and self.year==d2.year:
            return False
        else:
            return True
    
    def isAfter(self,d2):
        '''Returns true if self date is after d2'''
        if self.isBefore(d2)==True or self.equals(d2)==True:
            return False
        else:
            return True

    def diff(self, d2):
        '''Returns how many days are there in between self and d2'''
        d=Date(self.month, self.day, self.year)
        c=0
        while d.isAfter(d2):
            c=c+1
            d.yesterday()
        while d.isBefore(d2):
            c=c-1
            d.tomorrow()
        
        return c

    def dow(self):
        '''Return what day of the week self is'''
        use = Date(4, 26, 2022)
        if use.isAfter(self):
            if abs(use.diff(self)) % 7 == 0:
                return 'Tuesday'
            if abs(use.diff(self)) % 7 == 1:
                return 'Monday'
            if abs(use.diff(self)) % 7 == 2:
                return 'Sunday'
            if abs(use.diff(self)) % 7 == 3:
                return 'Saturday'
            if abs(use.diff(self)) % 7 == 4:
                return 'Friday'
            if abs(use.diff(self)) % 7 == 5:
                return 'Thursday'
            if abs(use.diff(self)) % 7 == 6:
                return 'Wednesday'
                       
            
        if use.isBefore(self):
            if abs(use.diff(self)) % 7 == 0:
                return 'Tuesday'
            if abs(use.diff(self)) % 7 == 1:
                return 'Wednesday'
            if abs(use.diff(self)) % 7 == 2:
                return 'Thursday'
            if abs(use.diff(self)) % 7 == 3:
                return 'Friday'
            if abs(use.diff(self)) % 7 == 4:
                return 'Saturday'
            if abs(use.diff(self)) % 7 == 5:
                return 'Sunday'
            if abs(use.diff(self)) % 7 == 6:
                return 'Monday'

