'''
Created on: 03/29/2022

@author:   Harsh Patel  CWID: 20005159
           Anish Subedi CWID: 20007841

Pledge: I pledge my honor that I have abided by the Stevens Honor System

CS115 - Hw 6
'''

from functools import reduce


COMPRESSED_BLOCK_SIZE = 5
MAX_RUN_LENGTH = 2 ** COMPRESSED_BLOCK_SIZE - 1

def add(x, y):
    """Returns sum"""
    return x + y

def ConsecutiveCount(S):
    """Returns the count for the how many times the first integer is consecutive"""
    if S == '':
        return 0
    elif len(S) == 1:
        return 1
    elif S[0] == S[1]:
        return 1 + ConsecutiveCount(S[1:])
    else:
        return 1
    
def ListofConsecutives(S):
    """Returns a list of the values of the consecutive integers in succession"""
    if S == '':
        return []
    return [ConsecutiveCount(S)] + ListofConsecutives(S[ConsecutiveCount(S):])

def Breakinglessthanmax(L):
    """Breaks the numbers up so they are not larger than the maximum run length"""
    if L == []:
        return []
    elif L[0] > MAX_RUN_LENGTH:
        L[0] = L[0] - MAX_RUN_LENGTH
        return [MAX_RUN_LENGTH, 0] + Breakinglessthanmax(L)
    return [L[0]] + Breakinglessthanmax(L[1:]) 

    
def numToBinary(n):
    '''This function returns the binary representation of non-negative integer n'''
    if n == 0: 
        return ''
    elif n%2==1:
        return numToBinary(n // 2) + '1'
    else:
        return numToBinary(n // 2) + '0'

def Padding(s):
    '''This function is to return correct block size'''
    if len(s) >= COMPRESSED_BLOCK_SIZE:
        return s
    else:
        return Padding('0'+s)
    
def compress(S):
    """Takes a binary string and returns a new binary string that is the input's run-to-length encoding"""
    if S == '':
        return ''
    elif S[0] == '1':
        return '0' * COMPRESSED_BLOCK_SIZE + reduce(add, map(Padding, map(numToBinary, Breakinglessthanmax(ListofConsecutives(S)))))
    else:
        return reduce(add, map(Padding, map(numToBinary, Breakinglessthanmax(ListofConsecutives(S)))))

def binaryToNum(s):
    '''Returns integer from the binary representation.'''
    if s == '':
        return 0
    else:
        if s[0] == '1':
            return binaryToNum(s[1:]) + 2**(len(s)-1)
        else:
            return binaryToNum(s[1:])
    
def Blockwiseuncompress(n, s):
    '''This function takes COMPRESSED_BLOCK_SIZE of string and decompresses it and returns decompressed string'''
    if s == '':
        return ''
    elif n == 1:
        return binaryToNum(s[:5]) * '1' + Blockwiseuncompress(0, s[5:])
    elif n == 0:
        return binaryToNum(s[:5]) * '0' + Blockwiseuncompress(1, s[5:])
def uncompress(S):
    '''Returns uncompressed string of S''' 
    if S == '':
        return 0
    return Blockwiseuncompress(0, S)

def compression(s):
    '''Returns ration of the compressed string and regular string'''
    return len(compress(s))/len(s)


#Question:
'''Here, Prof. Lai, is talking about a general algorithm that takes a 64-bit string and always outputs shorter strings that represent that image.
And can uncompress back. Such an algorithm cannot exists. Image compression is based on multiple factors based on which different algorithm is designed.
And, one algorithm cannot handle all the edge cases. For example, if two or more consecutive pixels have some exact color or not, no of average row, number of different color present.'''

