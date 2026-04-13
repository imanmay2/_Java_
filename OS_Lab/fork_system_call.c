#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
int main(){
    // pid_t pid;
    // pid=fork();
    // if(pid<0){
    //     printf("Fork failed");
    // }else if(pid==0){
    //     //child process
    //     printf("Child process id : %d\n",getpid());
    //     printf("Parent process id : %d ",getppid());
    // }else{
    //     //parent process
    //     printf("My child process id : %d\n",pid);
    //     printf("Parent / my Id is : %d",getpid());
    // }


    pid_t pid;
    if(fork() && fork()){
        fork();
    }
    printf("Hello\n");
}