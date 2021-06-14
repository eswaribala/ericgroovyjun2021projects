package com.eric.insurance


//array and random number

count=new Random().nextInt(100)

travellers=new String[count]

travellers[0]="Anand"
println "$travellers"
//introduce the loop
for(int i=0;i<count;i++) {
	travellers[i]="Traveller"+new Random().nextInt(1000)
}

//sorted travellers list
travellers.sort()

println "$travellers"