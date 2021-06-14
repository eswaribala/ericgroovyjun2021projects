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

//List

countryList=[]

count=new Random().nextInt(100)
for(int i=0;i<count;i++) {
	countryList.push("Country"+new Random().nextInt(1000))
}

//to read values from the list
countryList.each{println it}

//Map

//key pair value
//dynamic map
travelList=[['name':'traveller1','country':'USA'],['name':'traveller2','country':'UK']]
println "$travelList"
travelList[0].put('duration', 10)
travelList[1].put('duration', 20)
//println "$travelList[0]"
travelList.forEach{t->
entries=t.entrySet();
entries.forEach { entry ->
	println "$entry.key,$entry.value"
	
}

}


