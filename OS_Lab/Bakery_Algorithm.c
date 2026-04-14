#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<pthread.h>
#include<unistd.h>

#define n 5
bool choosing[n];
int numbers[n];

void lock(int i){
    choosing[i]=true; //lock

    int max=0;
    for(int j=0;j<n;j++){
        if(max<numbers[j]){
            max=numbers[j];
        }
    }
    numbers[i]=max+1; //give the highest token.

    choosing[i]=false; //choosing is done

    //see if other processes are choosing. 
    for(int j=0;j<n;j++){
        while(choosing[j]);
        while(numbers[j]!=0 && numbers[j]<numbers[i] || (numbers[j]==numbers[i] && j<i));
    }
}


void unlock(int i){
    numbers[i]=0; //unlocked/ done with critical section.
}


void *process(void *args){
    int i=*(int *)args;
    while(1){
        lock(i);

        printf("Process %d is in critical section.\n ",i);

        unlock(i);

        sleep(1);

        printf("Process %d is in remainder section. \n",i);

        sleep(1);

        return NULL;
    }
}

int main(){
    //initialization
    int id[n];
    for(int i=0;i<n;i++){
        numbers[i]=0;
        id[i]=i;
        choosing[i]=false;
    }

    pthread_t threads[n];
    for(int i=0;i<n;i++){
        //creating threads
        pthread_create(&threads[i],NULL,process,&id[i]);
    }

    for(int i=0;i<n;i++){
        pthread_join(threads[i],NULL);
    }
}