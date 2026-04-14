#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<semaphore.h>
#include<pthread.h>

#define n 5
int in=0;
int out=0;
sem_t empty;
sem_t full;
sem_t mutex;
int buffer[n];

void *producer(void *args){
    int item;
    for(int i=0;i<n;i++){
        item=i+1;

        sem_wait(&empty);
        sem_wait(&mutex);

        buffer[in]=item;
        printf("Item produced : %d %d",item,in);
        in=(in+1)%n;

        sem_post(&mutex);
        sem_post(&full);

        return NULL;
    }
}

void *consumer(void *args){
    int item;
    for(int i=0;i<n;i++){
        sem_wait(&full);
        sem_wait(&mutex);

        item=buffer[out];
        printf("Item consumed : %d from idx : %d",item,out);

        out=(out+1)%n;

        sem_post(&mutex);
        sem_post(&empty);
        return NULL;
    }
}

int main(){
    sem_init(&empty,0,n);
    sem_init(&full,0,0);
    sem_init(&mutex,0,1); //binary semaphore -0 ,1 
    
    pthread_t p1,p2;

    pthread_create(&p1,NULL,producer,NULL);
    pthread_create(&p2,NULL,consumer,NULL);

    pthread_join(p1,NULL);
    pthread_join(p2,NULL);

    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&mutex);
}