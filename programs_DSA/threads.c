#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>

void *process1(void *args){
    printf("Process is running on Thread 1\n");
    for(int i=0;i<3;i++){
        printf("%d\n",i*i);
    }

    pthread_exit(NULL);
}

void *process2(void *args){
    printf("Process is running on thread 2\n");
    for(int i=0;i<3;i++){
        printf("Sleep");
    }

    pthread_exit(NULL);
}

int main(){
    pthread_t t1,t2;
    pthread_create(&t1,NULL,process1,NULL);
    pthread_create(&t2,NULL,process2,NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    printf("Both threads executed successfully.\n");
    return 0;
}