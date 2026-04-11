#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>

int lock=0;
int shared=0;
int test_and_set(int *lock){
    // int old=*lock;
    // *lock=1;
    // return old;
    return __sync_lock_test_and_set(lock,1);
}

void *process1(void *args){
    for(int i=0;i<5;i++){
        while(test_and_set(&lock)){}

        printf("Process 1 is in critical section with shared value : %d\n",shared++);
        usleep(5000);
        lock=0;
    }
    return NULL;
}

void *process2(void *args){
    for(int i=0;i<5;i++){
        while(test_and_set(&lock)){}

        printf("Process 2 is in critical section with shared value : %d\n",shared++);
        usleep(5000000);

        lock=0;
    }
    return NULL;
}

int main(){
    pthread_t t1,t2;
    pthread_create(&t1,NULL,process1,NULL);
    pthread_create(&t2,NULL,process2,NULL);
    
    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    printf("Program has been teerminated \n");
    return 0;

}