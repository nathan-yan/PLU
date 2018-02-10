f = open("bomb.dat")

contents = f.readlines()

for c in range (len(contents)):
    contents[c] = contents[c].replace('\n', '')

problems = int(contents[0])

def getValid(z, i, j, l, h, w, c, bombs):
    valid = []

    if (i + 1 < h):
        valid.append([z, i + 1, j, c, bombs])
    
    if (j + 1 < w):
        valid.append([z, i, j + 1, c, bombs]) 
    
    if (i - 1 >= 0):
        valid.append([z, i - 1, j, c, bombs])
    
    if (j - 1 >= 0):
        valid.append([z, i, j - 1, c, bombs])

    if (z + 1 < l):
        valid.append([z + 1, i, j, c, bombs])
    
    if (z - 1 >= 0):
        valid.append([z - 1, i, j, c, bombs])

    return valid

counter = 1
for p in range (problems):
    layers, r, c = contents[counter].split(' ')

    r, c, layers = int(r), int(c), int(layers)

    startPos = None
    boardNew = []

    counter += 1
    for layer in range (layers):
        layerTemp = []
        for row in range (r):
            temp = []

            r_ = contents[counter]

            for character in range (len(r_)):
                
                if (r_[character] == '#'):
                    temp.append(0)
                else:
                    temp.append(1)

                if (r_[character] == 'S'):
                    startPos = [layer, row, character]
                elif (r_[character] == 'E'):
                    end = [layer, row, character]

            layerTemp.append(temp)

            counter += 1
        
        boardNew.append(layerTemp)
    
    board = boardNew

    
    totalMoves = 0
    
    tempBoard = [[[0 for j in range (len(board[0][0]))] for i in range (len(board[0]))] for z in range (len(board))]
    tempBoard2 = [[[0 for j in range (len(board[0][0]))] for i in range (len(board[0]))] for z in range (len(board))]

    # first find path from p1 to startPos
    seen = set()
    neighborsLeft = []
    neighborsLeft = [[end[0], end[1], end[2], 0, 0]]

    while len(neighborsLeft) != 0:
        consider = neighborsLeft[-1]

        if tempBoard[consider[0]][consider[1]][consider[2]] == 0 and (consider[0] != end[0] or consider[1] != end[1] or consider[2] != end[2]):
            tempBoard[consider[0]][consider[1]][consider[2]] = consider[3] + 1


        if (board[consider[0]][consider[1]][consider[2]]):
                tempBoard2[consider[0]][consider[1]][consider[2]] = consider[4]

        else:
            if (board[consider[0]][consider[1]][consider[2]] == 0):            
                tempBoard2[consider[0]][consider[1]][consider[2]] = consider[4] + 1
            else:
                tempBoard2[consider[0]][consider[1]][consider[2]] = min(tempBoard2[consider[0]][consider[1]][consider[2]] , consider[4] + 1)

        if(consider[0] * 10000 + consider[1] * 10000 + consider[2] not in seen ):
            neighborsLeft = getValid(consider[0], consider[1], consider[2], len(board), len(board[0]), len(board[0][0]), tempBoard[consider[0]][consider[1]][consider[2]], tempBoard2[consider[0]][consider[1]][consider[2]]) + neighborsLeft
            seen.add(consider[0] * 10000 + consider[1] * 10000 + consider[2])

        del neighborsLeft[-1]

    totalMoves += tempBoard2[startPos[0]][startPos[1]][startPos[2]]

    
    print(totalMoves - 1)
