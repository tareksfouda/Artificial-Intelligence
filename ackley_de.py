import random
import copy
import math
f=open("outputdiff.txt","w")
np=10
nc=100
F=0.8
CR=0.1
list=[]
array={}
newarray={}
minimum = 5.0

def ackley(x,y):
	fun= (-20)*math.exp(-0.2*math.sqrt(0.5*((x*x)+(y*y)))) - math.exp(0.5*(math.cos(math.radians(2*180*x))+math.cos(math.radians(2*180*y)))) + 20 + math.e 
	return fun

for i in range(0,100):
	outputlist=[]
	for l in range (0,np):
		x=random.uniform(-5,5)
		y=random.uniform(-5,5)
		newarray[l]=(x,y)
	#	print "___"
	#print newarray
	#print "____"
	for k in range(0,nc):
		array=newarray.copy()
		for i in range(0,np):
			a= random.sample(range(0,np),3)
			while True:
				if i not in a:
					list=a

					break
				else:
					a= random.sample(range(0,np),3)

			v1=array[list[0]][0]+(F*(array[list[1]][0]-array[list[2]][0]))
			v2=array[list[0]][1]+(F*(array[list[1]][1]-array[list[2]][1]))		

			n=random.uniform(0,1)

			if(n<CR):
				U1=v1
			else:
				U1=array[i][0]
			n=random.uniform(0,1)

			if(n<CR):
				U2=v2
			else:
				U2=array[i][1]

			newvalue=ackley(U1,U2)
			oldvalue=ackley(array[i][0],array[i][1])

			if (newvalue<oldvalue):
				newarray[i]=(U1,U2)
			else:
				newarray[i]=(array[i][0],array[i][1])
						

	for i in range(0,10):
		outputlist.append(ackley(newarray[i][0],newarray[i][1]))

	minlist= min(outputlist)
	if minlist < minimum:
		f.write("\n"+str(minlist))
		print minlist
		minimum = minlist

	
	
f.close()