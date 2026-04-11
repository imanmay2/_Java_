#include<stdio.h>
#include<unistd.h>
#include<pthread.h>

int flag[2]={0,0};
int shared=0;
int turn;

void *process1(void *args){
    for(int i=0;i<8;i++){
        flag[0]=1;
        turn=1;
        while(flag[1] && turn==1){}

        //cs
        printf("Process 0 is in critical section ,shared value is : %d\n",shared++);
        usleep(5000000);

    //exit section
        flag[0]=0;
    }
    return NULL;
}

void *process2(void *args){
    for(int i=0;i<5;i++){
        flag[1]=1;
    turn=0;
    while(flag[0] && turn==0){}

    //cs
    printf("Process 1 is in critical section ,shared value is : %d\n",shared++);
    usleep(5000000);


    //exit section
    flag[1]=0;
    }
    return NULL;
}
int main(){
    pthread_t t1,t2;
    pthread_create(&t1,NULL,process1,NULL);
    pthread_create(&t2,NULL,process2,NULL);

    pthread_join(t1,NULL);
    pthread_join(t2,NULL);

    printf("Petersolution Terminated\n");
}