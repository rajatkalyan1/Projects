#include <iostream>
#include <cassert>
#include "String.h"
#include "CustomerDB.h"

using namespace std;

const int default_capacity = 1;

Customer::Customer(String name) { // done, please do not edit
	this->bottles = 0;
	this->rattles = 0;
	this->diapers = 0;
	this->name = name;
}

CustomerDB::CustomerDB(void) { // done, please do not edit
	this->capacity = default_capacity;
	this->data = new Customer[this->capacity];
	this->length = 0;
}

int CustomerDB::size(void) {
	return this->length;
}

CustomerDB::~CustomerDB(void) { // done, please do not edit
	delete[] this->data;
}

void CustomerDB::clear(void) { // done, please do not edit
	delete[] this->data;
	this->capacity = default_capacity;
	this->data = new Customer[this->capacity];
	this->length = 0;
}

Customer& CustomerDB::operator[](int k) { // done, please do not edit
	assert(k >= 0 && k < this->length);
	return this->data[k];
}

Customer& CustomerDB::operator[](String name) {
	if (this->isMember(name))
	{
		for (int x = 0; x < this->length; x++)
		{
			if (data[x].name == name)
			{
				return data[x];
			}
		}
	}
	if (this->length == this->capacity){
		Customer* temp = new Customer[this->capacity + 1];
		for (int x = 0; x < this->length; x++){
			temp[x] = this->data[x];
		}
		delete this;
		this->data = temp;
		this->capacity++;
	}
	this->data[length] = Customer(name);
	this->length++;
	return this->data[this->length - 1];

}



bool CustomerDB::isMember(String name) {
	for (int x = 0; x < this->size(); x++){
		if (data[x].name == name)
			return true;
	}
	return false;
}


