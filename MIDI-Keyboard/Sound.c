// Sound.c, 
// This module contains the SysTick ISR that plays sound
// Runs on LM4F120 or TM4C123
// Program written by: put your names here
// Date Created: 8/25/2013 
// Last Modified: 10/9/2013 
// Section 1-2pm     TA: Saugata Bhattacharyya
// Lab number: 6
// Hardware connections
#include "tm4c123gh6pm.h"
#include "dac.h"
#include "SysTickInts.h"
#define PF2                     (*((volatile unsigned long *)0x40025010))
		
const unsigned short wave[32] = {			// 4-bit 32-element sine wave	
  8,9,11,12,13,14,14,15,15,15,14,			
  14,13,12,11,9,8,7,5,4,3,2,			
  2,1,1,1,2,2,3,4,5,7};			
		


unsigned long count = 0;	
unsigned long Data;
// put code definitions for the software (actual C code)
// this file explains how the module works

// **************Sound_Init*********************
// Initialize Systick periodic interrupts
// Input: interrupt period
//           Units to be determined by YOU
//           Maximum to be determined by YOU
//           Minimum to be determined by YOU
// Output: none
void Sound_Init(unsigned long period){
		DAC_Init();
		SysTick_Init(period);
}

// **************Sound_Play*********************
// Start sound output, and set Systick interrupt period 
// Input: interrupt period
//           Units to be determined by YOU
//           Maximum to be determined by YOU
//           Minimum to be determined by YOU
//         input of zero disable sound output
// Output: none
void Sound_Play(unsigned long period){
		NVIC_ST_RELOAD_R = period;
}

// Interrupt service routine
// Executed every periodically
void SysTick_Handler(void){
			if(count == 32){
			count=0;
		}
		Data = wave[count];
		DAC_Out(Data);
		count += 1;
		PF2 ^= 0x04;                // toggle PF2
	}
	
