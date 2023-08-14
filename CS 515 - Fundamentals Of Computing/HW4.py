"""
Name- Harsh Maheshbhai Patel
CWID- 20005159
I pledge my honor that I have abided by the Stevens Honor System.
"""

from functools import reduce

def sum(x,y):
    return x+y

def pascal_row(i):
    """
    takes an integer parameter and returns a list of a elements of ith row of
    pascal triangle
    """
    l=[]
    l.insert(0,1)
    if i==0:
        return l

    if i==1:
        l.insert(i,1)
        return l
    else:
        li=previous_sum(pascal_row(i-1),[])
        
    l.extend(li)    
    l.insert(i,1)
    return l


def previous_sum(l,li):
    #helper function
    """
    returns a list of sum of two elements 
    """
    if len(l)==1:
        return li
    else:
        li.append(l[1] + l[0])
        return previous_sum(l[1:],li)

def pascal_triangle(n):
    """
    take an integer parameter and returns n lines of pascal triangle
    """
    li=previous_triangle(n,[])
    li.reverse()
    return li

def previous_triangle(n,l):
    #helper function
    """
    adds row by row of pascal triangle to a list and returns to a pascal triangle
    """
    if n==0:
        l.append(pascal_row(n))
        return l
    else:
        l.append(pascal_row(n))
        l.append(previous_triangle((n-1),l))
        return l[:(n+1)]

def test_pascal_row():
    """
    test cases for pascal row function
    """
    assert pascal_row(0)==[1]
    assert pascal_row(1)==[1, 1]
    assert pascal_row(2)==[1, 2, 1]
    assert pascal_row(3)==[1, 3, 3, 1]
    assert pascal_row(4)==[1, 4, 6, 4, 1]
    assert pascal_row(5)==[1, 5, 10, 10, 5, 1]

def test_pascal_triangle():
    """
    test cases for pascal triangle
    """
    assert pascal_triangle(0)==[[1]]
    assert pascal_triangle(1)==[[1], [1, 1]]
    assert pascal_triangle(2)==[[1], [1, 1], [1, 2, 1]]
    assert pascal_triangle(3)==[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
    assert pascal_triangle(4)==[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    assert pascal_triangle(5)==[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1]]
