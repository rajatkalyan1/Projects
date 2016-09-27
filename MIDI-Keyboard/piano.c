// Piano.c
// This software configures the off-board piano keys
// Runs on LM4F120 or TM4C123
// Program written by: put your names here
// Date Created: 8/25/2013 
// Last Modified: 10/9/2013 
// Section 1-2pm     TA: Saugata Bhattacharyya
// Lab number: 6
// Hardware connections

#include "tm4c123gh6pm.h"

#define GPIO_PORTD_DATA_R       (*((volatile unsigned long *)0x400073FC))
#define GPIO_PORTD_DIR_R        (*((volatile unsigned long *)0x40007400))
#define GPIO_PORTD_AFSEL_R      (*((volatile unsigned long *)0x40007420))
#define GPIO_PORTD_DEN_R        (*((volatile unsigned long *)0x4000751C))
#define SYSCTL_RCGC2_R          (*((volatile unsigned long *)0x400FE108))
// put code definitions for the software (actual C code)
// this file explains how the module works

// **************Piano_Init*********************
// Initialize piano key inputs, called once 
// Input: none 
// Output: none
void Piano_Init(void){
		volatile unsigned long delay;
		SYSCTL_RCGC2_R |= 0x08;
		delay = SYSCTL_RCGC2_R;
		GPIO_PORTD_DIR_R &= ~0x07;  					
		GPIO_PORTD_AFSEL_R &= ~0x07;        
		GPIO_PORTD_DEN_R |= 0x07;
  }
// **************Piano_In*********************
// Input from piano key inputs 
// Input: none 
// Output: 0 to 7 depending on keys
// 0x01 is just Key0, 0x02 is just Key1, 0x04 is just Key2
unsigned long Piano_In(void){ 
	unsigned long data = GPIO_PORTD_DATA_R;
	return data;
		
}
