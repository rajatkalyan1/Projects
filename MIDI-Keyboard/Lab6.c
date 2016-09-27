// Lab6.c
// Runs on LM4F120 or TM4C123
// Program written by: put your names here
// Date Created: 8/25/2013 
// Last Modified: 10/9/2013 
// Section 1-2pm     TA: Saugata Bhattacharyya
// Lab number: 6
// Brief description of the program
//   A digital piano with 4 keys and a 4-bit DAC
// Hardware connections


#include "tm4c123gh6pm.h"
#include "PLL.h"
#include "Sound.h"
#include "Piano.h"
#include "dac.h"
#include "SysTickInts.h"
#include "Melody.h"
#define PF2                     (*((volatile unsigned long *)0x40025010))


// basic functions defined at end of startup.s
void DisableInterrupts(void);	// Disable interrupts
void EnableInterrupts(void);  // Enable interrupts
long StartCritical (void);    // previous I bit, disable interrupts
void EndCritical(long sr);    // restore I bit to previous value
void WaitForInterrupt(void);  // low power mode
volatile unsigned long Counts = 0;



     
int main(void){
			volatile unsigned int input;
			SYSCTL_RCGC2_R |= SYSCTL_RCGC2_GPIOF; // activate port F
			Counts = 0;
			GPIO_PORTF_DIR_R |= 0x04;   // make PF2 output (PF2 built-in LED)
			GPIO_PORTF_AFSEL_R &= ~0x04;// disable alt funct on PF2
			GPIO_PORTF_DEN_R |= 0x04;   // enable digital I/O on PF2
																	// configure PF2 as GPIO
			GPIO_PORTF_PCTL_R = (GPIO_PORTF_PCTL_R&0xFFFFF0FF)+0x00000000;
			GPIO_PORTF_AMSEL_R = 0;     // disable analog functionality on PF
			PLL_Init();                 // bus clock at 50 MHz
			Piano_Init();
			Sound_Init(80000000);	
			
	
			while(1){
					input = Piano_In();// interrupts every 1ms, 500 Hz flash
				switch(input)
				{
           case 1:
						    EnableInterrupts();
					      Sound_Play(A);
								break;
					 case 2:
								EnableInterrupts();
								Sound_Play(DF1);
								break;
					 case 4:
								EnableInterrupts();
								Sound_Play(E1);
								break;
					 case 7:
								EnableInterrupts();
								Melody();
								break;
					 default:
								DisableInterrupts();
        }
			}
}
 

 

