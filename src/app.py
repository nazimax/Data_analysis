
import numpy as np
import os
corr = open("./corrMatrix", "r+")
a = corr.read()

A = np.mat(a)
b = np.asarray(A)

print "CORRELATION MATRIX : \n",A

eigen = np.linalg.eigh(b)
eigenvalue = np.flip(eigen[0], 0)
eigenvector = np.flip(np.transpose(eigen[1]), 0)


eigVal = open("./eigenValues", "w")
eigVec = open("./eigenVectors", "w")


for i in eigenvalue:

    eigVal.write(str('{:f}'.format(i))+";")



for j in eigenvector:
    eigVec.write(str(j)+"\n")

corr.close()
eigVal.close()
eigVec.close()

tocompile = "javac Main.java"
run = "java Main"


os.system(tocompile)
os.system(run)


