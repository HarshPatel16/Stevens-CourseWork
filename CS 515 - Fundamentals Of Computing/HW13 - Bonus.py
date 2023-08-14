"""
Name- Harsh Maheshbhai Patel
CWID- 20005159
I pledge my honor that I have abided by the Stevens Honor System.
"""

class Board(object):
    def __init__(self, width = 7, height = 6):
        """
        Initializes board with standard width and height
        """
        self.__width = width
        self.__height = height
        board = []
        for _ in range(height):
            row = []
            for _ in range(width):
                row.append(' ')
            board.append(row)
        self.__board = board
    
    @property
    def width(self):
        return self.__width
    @width.setter
    def width(self, width):
        self.__width = width
    @property
    def height(self):
        return self.__height
    @height.setter
    def height(self, height):
        self.__height = height
    
    def __str__(self):
        """Shows board layout"""
        result = ""
        for i in range(len(self.__board)):
            result = result + '|'
            for s in self.__board[i]:
                result = result + s + '|'
            result = result + '\n'
        for _ in range(len(self.__board[0])  * 2 + 1):
            result = result + '-'
        result = result + '\n'
        for i in range(len(self.__board[0])):
            result = result + ' ' + str(i)
        return result
    
    def allowsMove(self, col):
        """Checks if there is free space in column"""
        if col not in range(self.__width):
            return False
        else:
            return self.__board[0][col] == ' '

    def addMove(self, col, ox):
        """Adds move to the provide column"""
        if self.allowsMove(col) == True:
            if self.__board[self.__height - 1][col] != ' ':
                for row in range(self.__width - 2):
                    if self.__board[row][col] == ' ' and self.__board[row + 1][col] != ' ':
                        self.__board[row][col] = ox
            else:
                self.__board[self.__height - 1][col] = ox
    
    def setBoard( self, moveString ):
        """ takes in a string of columns and places
             alternating checkers in those columns,
             starting with 'X'
            
             For example, call b.setBoard('012345')
             to see 'X's and 'O's alternate on the
             bottom row, or b.setBoard('000000') to
             see them alternate in the left column.
             moveString must be a string of integers
         """
        nextCh = 'X' # start by playing 'X'
        for colString in moveString:
            col = int(colString)
            if 0 <= col <= self.width:
                self.addMove(col, nextCh)
            if nextCh == 'X':
                nextCh = 'O'
            else: nextCh = 'X'
    
    
    def winsFor(self, ox):
        """
        Checks all the possibilities of winning for both the players
        """
        for col in range(self.__width):
            for row in range(self.__height - 3):
                if self.__board[row][col] == ox and self.__board[row + 1][col] == ox and self.__board[row + 2][col]  == ox and self.__board[row + 3][col] == ox:
                    return True
                
        for col in range(self.__width - 3):
            for row in range(self.__height):
                if self.__board[row][col] == ox and self.__board[row][col + 1] == ox and self.__board[row][col + 2]  == ox and self.__board[row][col + 3] == ox:
                    return True
        
        for row in range(self.__height - 3):
            for col in range(self.__width - 3):
                if self.__board[row][col] == ox and self.__board[row + 1][col + 1] == ox and self.__board[row + 2][col + 2]  == ox and self.__board[row + 3][col + 3] == ox:
                    return True
                
        for col in range(self.__width - 3):
            for row in range(self.__height):
                if self.__board[row][col] == ox and self.__board[row - 1][col + 1] == ox and self.__board[row - 2][col + 2]  == ox and self.__board[row - 3][col + 3] == ox:
                    return True
                
        return False
    
    def hostGame(self):
        """This is Interface of connect 4 game"""
        print("Welcome to Connect Four!")
        player = "X"
        choice = -1
        print(self)
        print()
        while True:
            correctInput = 0
            while correctInput == 0:
                if player == "X":
                    try:
                        choice = int(input("X's choice: "))
                        correctInput = 1
                    except ValueError:
                        correctInput = 0
                else:
                    try:
                        choice = int(input("O's choice: "))
                        correctInput = 1
                    except ValueError:
                        correctInput = 0
                if correctInput == 1 and self.allowsMove(choice):
                    correctInput = 1
                else:
                    print("Not a valid input!! Please input integer between 0 and " + str(self.__width - 1))
                    correctInput = 0
            if player == "O":
                self.addMove(choice, "O")
                player = "X"
            else:
                self.addMove(choice, "X")
                player = "O"
                
            print()
            
            if self.winsFor("X"):
                print()
                print("X wins -- Congratulations!")
                print()
                print(self)
                exit()
            elif self.winsFor("X"):
                print()
                print("O wins -- Congratulations!")
                print()
                print(self)
                exit()
            print(self)
            print()
                
if __name__ == '__main__':
    """if this is the main function, run the hostgame on a standard board"""
    b = Board()
    b.hostGame()
