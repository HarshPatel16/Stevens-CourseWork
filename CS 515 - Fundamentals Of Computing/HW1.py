"""
Harsh Maheshbhai Patel
20005159
I pledge my honor that I have abided by the Stevens Honor System.
"""


from functools import reduce
""" imports reduce function from functools"""

def mp(num):
    """creating list from 1 to n numbers"""

    if num==0:
        return [1]
    else:
        return list(range(1,num+1))

def mul(x,y):
    """multiplies x and y and returns the result"""
    return x*y

def fact(num):
    """returns multiplication of list of numbers from 1 to num"""
    return reduce(mul,mp(num))

def add(x,y):
    """returns sum of x and y"""
    return x+y

def mean(l):
    """takes a list as a parameter and returns mean of a list"""
    x= reduce(add, l)
    """it assigns sum of list of elements to x"""
    return x/len(l)
    """returns mean of list"""
    """or x//len(l) if you want round up answer"""
