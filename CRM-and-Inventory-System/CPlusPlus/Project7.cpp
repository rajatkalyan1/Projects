#include <stdio.h>
#include "String.h"
#include "Customer.h"
#include "CustomerDB.h"

void readString(String&);
void readNum(int&);

CustomerDB database;

int num_bottles = 0;
int num_rattles = 0;
int num_diapers = 0;


/* clear the inventory and reset the customer database to empty */
void reset(void) {
	database.clear();
	num_bottles = 0;
	num_rattles = 0;
	num_diapers = 0;
}

/*
 * selectInventItem is a convenience function that allows you
 * to obtain a pointer to the inventory record using the item type name
 * word must be "Bottles", "Diapers" or "Rattles"
 * for example the expression *selectInventItem("Bottles") returns the 
 * current global variable for the number of bottls in the inventory
 */
int* selectInventItem(String word) {
	if (word == "Bottles") {
		return &num_bottles;
	} else if (word == "Diapers") {
		return &num_diapers;
	} else if (word == "Rattles") {
		return &num_rattles;
	}
	
	/* NOT REACHED */
	return 0;
}

/*
 * this overload of selectInventItem is similar to selectInventItem above, however
 * this overload takes a Customer as a second argument and selects the data member
 * of that Customer that matches "word". The function returns a pointer to one of the three data
 * members from the specified customer.
 */
int* selectInventItem(String word, Customer& cust) {
	if (word == "Bottles") {
		return &cust.bottles;
	} else if (word == "Diapers") {
		return &cust.diapers;
	} else if (word == "Rattles") {
		return &cust.rattles;
	}
	
	/* NOT REACHED */
	return 0;
}


/*
 * findMax searches through the CustomerDB "database" and returns the Customer
 * who has purchased the most items of the specified type.
 * type must be one of "Bottles", "Rattles" or "Diapers".
 * 
 * Note: if two or more Customers are tied for having purchased the most of that item type
 * then findMax returns the first Customer in the CustomerDB who has purchased that maximal
 * quantity.
 *
 * Note: in the special case (invalid case) where there are zero Customers in the 
 * CustomerDB, fundMax returns a null pointer (0)
 */
Customer* findMax(String type) {
	Customer* result = 0;
	int max = 0;
	for (int k = 0; k < database.size(); k += 1) {
		Customer& cust = database[k];
		int *p = selectInventItem(type, cust); 
		if (*p > max) {
			max = *p;
			result = &cust;
		}
	}
	
	return result;
}

void processPurchase() {
	String cusName;
	readString(cusName);
	int newCus = 0;
	int begin = database.length;
	Customer& cus = database[cusName];
	int end = database.length;
	if (end > begin)
		newCus = 1;
	int purchased = 0;
	String item;
	int qty;
	readString(item);
	readNum(qty);
	if (item == "Bottles"){
		if (qty > num_bottles)
		{
			printf("Sorry %s, we only have ", cus.name.c_str());
			printf("%d Bottles\n", num_bottles);
		}
		else {
			cus.bottles += qty;
			num_bottles -= qty;
			purchased = 1;
		}
	}
	else if (item == "Rattles"){
		if (qty > num_rattles)
		{
			printf("Sorry %s, we only have ", cus.name.c_str());
			printf("%d Rattles\n", num_rattles);
		}
		else {
			cus.rattles += qty;
			num_rattles -= qty;
			purchased = 1;
		}
	}
	else if (item == "Diapers"){
		if (qty > num_diapers)
		{
			printf("Sorry %s, we only have ", cus.name.c_str());
			printf("%d Diapers\n", num_diapers);
		}
		else {
			cus.diapers += qty;
			num_diapers -= qty;
			purchased = 1;
		}
	}
	if (purchased == 0 && newCus == 1)
		database.length--;
}

void processSummarize()
{

	printf("There are %d Bottles, %d Diapers and %d Rattles in inventory\n", num_bottles, num_diapers, num_rattles);
	printf("we have had a total of %d different customers\n", database.size());
	Customer& cusB = *findMax("Bottles");
	Customer& cusD = *findMax("Diapers");
	Customer& cusR = *findMax("Rattles");
	if (&cusB == 0)
		printf("no one has purchased any Bottles\n");
	else{
		printf("%s has purchased the most Bottles ", cusB.name.c_str());
		printf("(%d)\n", cusB.bottles);
	}

	if (&cusD == 0)
		printf("no one has purchased any Diapers\n");
	else{
		printf("%s has purchased the most Diapers ", cusD.name.c_str());
		printf("(%d)\n", cusD.diapers);
	}

	if (&cusR == 0)
		printf("no one has purchased any Rattles\n");
	else{
		printf("%s has purchased the most Rattles ", cusR.name.c_str());
		printf("(%d)\n", cusR.rattles);
	}
}

void processInventory() {
	String item;
	int qty;
	readString(item);
	readNum(qty);
	if (item == "Bottles")
		num_bottles += qty;
	else if (item == "Rattles")
		num_rattles += qty;
	else if (item == "Diapers")
		num_diapers += qty;
}
