#include<iostream>
#include<cmath>

using namespace std;

//find the count for the diigits
long long digCount(long long num){


    if(num==0){
        return 1;
    }
    long long ct=0;
    while(num!=0){
        num=num/10;
        ct++;
    }return ct;
}


long long karatsuba(long long n1,long long n2){
    //base case
    if(n1<10 || n2<10){
        return n1*n2;
    }

    //else
    long n=max(digCount(n1),digCount(n2));
    int half=n/2;
    long long power=pow(10,half);

    long long a=n1/power;
    long long b=n1%power;
    long long c=n2/power;
    long long d=n2%power;

    //recursively calculate the multiplication.
    long long ac=karatsuba(a,c);
    long long bd=karatsuba(b,d);
    long long abcd=karatsuba(a+b,c+d);
    long long mid=abcd-ac-bd;
    return power*power*ac+mid*power+bd;
}


int main(){
    long long n1=1234;
    long long n2=5678;

    cout<<"Multiplication is : "<<karatsuba(n1,n2);
}