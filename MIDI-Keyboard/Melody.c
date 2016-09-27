// TONES  ==========================================
// Start by defining the relationship between 
//       note, period, &  frequency. 

// Define a special note, 'R', to represent a rest
#define  R     			0
#include "SysTickInts.h"
#define eighth					176000    // eighth is eighth note, quarter is quarter note, half is half note, dottedhalf is three quarter notes, whole is a whole note
#define quarter  				352000
#define half					704000		
#define dottedhalf				1056000		
#define whole					1408000
#define T						10000			//delay between two same frequency notes so that each one sounds like a different note instead of being slurred together
#define GPIO_PORTF_DATA_R       (*((volatile unsigned long *)0x400253FC))
#include "piano.h"
#include "dac.h"
#include "Sound.h"
#include "SysTickInts.h"
#include "Melody.h"
int i = 0;
int tone = 0;
int duration = 0;
int l = 0;
unsigned long checker;
int notes[280] = {D7,EF7,E7,C7,E7,C7,E7,C7,C7,C7,R,C7,D0,EF0,E0,C7,D0,E0,B7,D0,C7,D7,EF7,E7,C7,E7,C7,E7,C7,C7,A7,G7,GF7,A7,C7,E0,E0,D0,C7,A7,D0,D7,EF7,E7,C7,E7,C7,E7,C7,C7,C7,R,C7,D0,EF0,E0,C7,D0,E0,E0,B7,D0,C7,R,C7,D0,E0,C7,D0,E0,E0,C7,D0,C7,E0,C7,D0,E0,E0,C7,D0,C7,E0,C7,D0,E0,E0,B7,D0,C7,C7,E7,F7,GF7,G7,A7,G7,G7,E7,F7,GF7,G7,A7,G7,G7,E0,C7,G7,A7,B7,C7,D0,E0,D0,C7,D0,G7,E7,F7,A7,G7,E7,F7,G7,A7,G7,G7,E7,F7,GF7,G7,A7,G7,G7,R,G7,A7,BF7,B7,R,B7,R,B7,B7,A7,GF7,D7,G7,G7,E7,F7,GF7,G7,A7,G7,G7,E7,F7,GF7,G7,A7,G7,G7,E0,C7,G7,A7,B7,C7,D0,E0,D0,C7,D0,C7,C7,G7,GF7,G7,C7,A7,C7,C7,A7,C7,A7,G7,C7,E0,G0,G0,E0,C7,G7,A7,C7,E0,D0,C7,C7,R,D7,EF7,E7,C7,E7,C7,E7,C7,C7,C7,R,C7,D0,EF0,E0,C7,D0,E0,E0,B7,D0,C7,R,C7,D0,E0,C7,D0,E0,E0,C7,D0,C7,E0,C7,D0,E0,E0,C7,D0,C7,E0,C7,D0,E0,E0,B7,D0,C7,C7};
int beats[280] = {eighth,eighth,eighth,quarter,eighth,quarter,eighth,eighth,half,eighth,T,eighth,eighth,eighth,eighth,eighth,eighth,quarter,eighth,quarter,dottedhalf,eighth,eighth,eighth,quarter,eighth,quarter,eighth,dottedhalf,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,dottedhalf,eighth,eighth,eighth,quarter,eighth,quarter,eighth,eighth,half,eighth,T,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,quarter,dottedhalf,T,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,quarter,half,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,T,eighth,eighth,eighth,eighth,T,quarter,T,eighth,eighth,eighth,eighth,eighth,half,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,half,eighth,eighth,eighth,eighth,quarter,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,quarter,quarter,eighth,quarter,eighth,half,quarter,eighth,eighth,eighth,quarter,eighth,quarter,eighth,eighth,half,eighth,T,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,quarter,dottedhalf,T,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,eighth,quarter,half,eighth};
unsigned long pianoreturn;
int x =0;	
unsigned long heartbeat2;
	
void Melody(void) {
		for(i=0; i<260; i++) {
			pianoreturn = Piano_In();
		
			
				if(pianoreturn == 0x01) {			// these three break cases are if one of the other sound keys are pressed, the song will stop playing
					break;
				}
				if(pianoreturn == 0x02) {
					break;
				}
				if(pianoreturn == 0x04) {
					break;
				}
			tone = notes[i];
			duration = beats[i];
			SysTick_Init(tone);
			
		
		for(l=0; l<duration; l++) {
				if (heartbeat2 == 200000) {
			GPIO_PORTF_DATA_R ^= 0x04;
			heartbeat2 = 0;
				}
					heartbeat2 = heartbeat2 + 1;
				
		
		}
			if(i == 251) {			// if the song finishes, the song will start again from the beginning
				i = 0;
			}
			
	}
}



