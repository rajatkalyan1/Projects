// dac.c
// This software configures DAC output
// Runs on LM4F120 or TM4C123
// Program written by: put your names here
// Date Created: 8/25/2013 
// Last Modified: 10/9/2013 
// Section 1-2pm     TA: Saugata Bhattacharyya
// Lab number: 6
// Hardware connections

#include "tm4c123gh6pm.h"

#define GPIO_PORTB_DATA_R       (*((volatile unsigned long *)0x400053FC))
#define GPIO_PORTB_DIR_R        (*((volatile unsigned long *)0x40005400))
#define GPIO_PORTB_AFSEL_R      (*((volatile unsigned long *)0x40005420))
#define GPIO_PORTB_DEN_R        (*((volatile unsigned long *)0x4000551C))
#define SYSCTL_RCGC2_R          (*((volatile unsigned long *)0x400FE108))

// put code definitions for the software (actual C code)
// this file explains how the module works

// **************DAC_Init*********************
// Initialize 4-bit DAC, called once 
// Input: none
// Output: none
void DAC_Init(void){
		volatile unsigned long delay;
		SYSCTL_RCGC2_R |= 0x02;
		delay = SYSCTL_RCGC2_R;
		GPIO_PORTB_DIR_R |= 0x0F;  				
		GPIO_PORTB_AFSEL_R &= ~0x0F;        
		GPIO_PORTB_DEN_R |= 0x0F;
}

// **************DAC_Out*********************
// output to DAC
// Input: 4-bit data, 0 to 15 
// Output: none
void DAC_Out(unsigned long data){
		GPIO_PORTB_DATA_R = data;
}
