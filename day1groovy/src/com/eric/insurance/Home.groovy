package com.eric.insurance

//use stdout
//GroovyObject(I)-->GroovyObjectSupport(AC)--> Script(C)

println 'TRAVEL INSURANCE'

//understand data types
cover='SingleTrip/BackPackers'
money=4395696
confirmed=true
//get the data types
println cover.class.name
println money.class.name
println confirmed.class.name

//Gstrings
//double quotes
println "Insurance cover needed for the travel type = $cover"

//multi line use triple quotes
println """Insurance cover needed for the travel type = $cover 
and it is trip type $confirmed"""

//Read data from use

println "Enter your email"

email=System.in.newReader().readLine();

println "Customer Email Id is $email"

//java dialog box


//def readln = javax.swing.JOptionPane.&showInputDialog
//def countryName = readln 'Enter Country Name to travel?'
//println "Country Name = $countryName"

import java.text.SimpleDateFormat
import java.util.GregorianCalendar as D
import static java.util.Calendar.getInstance as now
import groovy.time.TimeCategory
dateOfTravel= new D(2021,6,15).time
println "$dateOfTravel"

//flexi dates for travel
//after a week from the planned date
use (groovy.time.TimeCategory) {
  println new Date()
  println 10.weeks.from.now
}


//Date parsing

pattern = "yyyy-MM-dd"
println "Enter Date of Travel"
dateOfTravel= System.in.newReader().readLine();

//string to date
formattedDate = new SimpleDateFormat(pattern).parse(dateOfTravel)

println "Date of Travel = $formattedDate"

//operator overloading
amount=3956979
println "The Original Travel Fee is $amount"
println "Amount increased by 5%"
amount=amount.plus(amount.multiply(0.05))
println "The updated fee for the travel $amount"





