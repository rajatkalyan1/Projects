/* 
 * EE312 Simple CRM Project
 *
 * YOUR INFO HERE!
 */

#include <stdio.h>
#include <assert.h>

#include "MyString.h"

#include "Invent.h"

#define MAX_CUSTOMERS 1000
Customer customers[MAX_CUSTOMERS];
int num_customers = 0;
int invenBottles = 0;
int invenRattles = 0;
int invenDiapers = 0;

/* you'll probably need several more global variables */
/* and of course, you have a few functions to write */


/* clear the inventory and reset the customer database to empty */
void reset(void) {
	for (int x = 0; x < num_customers; x++)
	{
		StringDestroy(&customers[x].name);
	}
	invenBottles = 0;
	invenDiapers = 0;
	invenRattles = 0;
	num_customers = 0;
}

void processSummarize() {
	printf("There are %d Bottles, %d Diapers and %d Rattles in inventory\n", invenBottles, invenDiapers, 
		invenRattles);
	printf("we have had a total of %d different customers\n", num_customers);
	int maxBot = 0;
	int maxRat = 0;
	int maxDiap = 0;
	int maxBotCus = 0;
	int maxRatCus = 0;
	int maxDiapCus = 0;
	for (int x = 0; x < num_customers; x++){
		if (customers[x].bottles > maxBot)
		{
			maxBot = customers[x].bottles;
			maxBotCus = x;
		}
		if (customers[x].rattles > maxRat)
		{
			maxRat = customers[x].rattles;
			maxRatCus = x;
		}
		if (customers[x].diapers > maxDiap)
		{
			maxDiap = customers[x].diapers;
			maxDiapCus = x;
		}
	}
	if (maxBot > 0)
	{
		StringPrint(&customers[maxBotCus].name);
		printf(" has purchased the most Bottles (%d)\n", maxBot);
	}
	else
		printf("no one has purchased any Bottles\n");
	if (maxDiap > 0)
	{
		StringPrint(&customers[maxDiapCus].name);
		printf(" has purchased the most Diapers (%d)\n", maxDiap);
	}
	else
		printf("no one has purchased any Diapers\n");
	if (maxRat > 0)
	{
		StringPrint(&customers[maxRatCus].name);
		printf(" has purchased the most Rattles (%d)\n", maxRat);
	}
	else
		printf("no one has purchased any Rattles\n");
}

void processPurchase() {
	String cusName;
	String item;
	int purchase = 0;
	int num;
	String bot = StringCreate("Bottles");
	String rat = StringCreate("Rattles");
	String diap = StringCreate("Diapers");
	readString(&cusName);
	int exists = 0;
	int cusIndex;
	int x = 0;
	while (x < num_customers)
	{
		if (StringIsEqualTo(&customers[x].name, &cusName))
		{
			exists = 1;
			cusIndex = x;
			break;
		}
		else
			x++;
	}
	if (exists == 0)
	{
		/*Customer newCus;
		newCus.bottles = 0;
		newCus.rattles = 0;
		newCus.diapers = 0;
		newCus.name = StringDup(&cusName);*/
		customers[x].bottles = 0;
		customers[x].rattles = 0;
		customers[x].diapers = 0;
		customers[x].name = StringDup(&cusName);
		//customers[x] = newCus;
	}
	readString(&item);
	readNum(&num);
	if (StringIsEqualTo(&item, &bot))
	{
		if (invenBottles < num){
			printf("Sorry ");
			StringPrint(&customers[x].name);
			printf(", we only have %d Bottles\n", invenBottles);
		}
		else {
			customers[x].bottles += num;
			invenBottles -= num;
			purchase = 1;
		}
	}
	else if (StringIsEqualTo(&item, &rat))
	{
		if (invenRattles < num)
		{
			printf("Sorry ");
			StringPrint(&customers[x].name);
			printf(", we only have %d Rattles\n", invenRattles);
		}
		else {
			customers[x].rattles += num;
			invenRattles -= num;
			purchase = 1;
		}
	}
	else if (StringIsEqualTo(&item, &diap))
	{
		if (invenDiapers < num){
			printf("Sorry ");
			StringPrint(&customers[x].name);
			printf(", we only have %d Diapers\n", invenDiapers);
		}
		else {
			customers[x].diapers += num;
			invenDiapers -= num;
			purchase = 1;
		}
	}
	if (purchase > 0 && exists == 0)
		num_customers++;
	if (purchase == 0 && exists == 0)
		StringDestroy(&customers[x].name);
	StringDestroy(&cusName);
	StringDestroy(&item);
	StringDestroy(&bot);
	StringDestroy(&rat);
	StringDestroy(&diap);
}

void processInventory() {
	String str;
	int num;
	String bot = StringCreate("Bottles");
	String rat = StringCreate("Rattles");
	String diap = StringCreate("Diapers");
	readString(&str);
	readNum(&num);
	if (StringIsEqualTo(&str, &bot))
		invenBottles += num;
	else if (StringIsEqualTo(&str, &rat))
		invenRattles += num;
	else if (StringIsEqualTo(&str, &diap))
		invenDiapers += num;
	StringDestroy(&str);
	StringDestroy(&bot);
	StringDestroy(&rat);
	StringDestroy(&diap);
}
