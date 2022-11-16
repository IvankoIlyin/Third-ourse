
#include <iostream>
#include <WinSock2.h>
#include <WS2tcpip.h>
#include <windows.h>
#include <tchar.h>
#include <stdio.h>
#include <vector>
#include <future>
#include <thread>

#pragma comment(lib, "Ws2_32.lib")
using namespace std;

int goClientF(TCHAR t2[30], STARTUPINFO si, PROCESS_INFORMATION pi) {
    if (!CreateProcess(L"D:\\University\\Third-ourse\\firstTerm\\os\\lab1\\clientF\\Release\\clientF.exe", t2, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        printf("CreateProcess failed (%d).\n", GetLastError());
        return -1;
    }

}
 
int goClientG(TCHAR t2[30], STARTUPINFO si, PROCESS_INFORMATION pi) {
    if (!CreateProcess(L"D:\\University\\Third-ourse\\firstTerm\\os\\lab1\\clientG\\Release\\clientG.exe", t2, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        printf("CreateProcess failed (%d).\n", GetLastError());
        return -1;
    }

}

void wait(bool& finish) {
    Sleep(1000);
    finish = true;
    
}


int main()
{
    const char* t1 = "1";
    TCHAR t2[30];
    swprintf(t2, 30, L"%hs", t1);
    STARTUPINFO si/*,si2*/;
    PROCESS_INFORMATION pi/*,pi2*/;
    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));

   goClientF(t2, si, pi);
   goClientG(t2, si, pi);
  /*  if (!CreateProcess(L"D:\\University\\Third-ourse\\firstTerm\\os\\lab1\\clientF\\Release\\clientF.exe", t2, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
            printf("CreateProcess failed (%d).\n", GetLastError());
            return -1;
        }

    if (!CreateProcess(L"D:\\University\\Third-ourse\\firstTerm\\os\\lab1\\clientG\\Release\\clientG.exe", t2, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        printf("CreateProcess failed (%d).\n", GetLastError());
        return -1;
    }
    */

    const char IP_SERV[] = "192.168.1.107";
    const int PORT_NUMF = 1488;
    const int PORT_NUMG = 1337;
    const short BUFF_SIZE = 1024;

    int erStat;
    in_addr ip_to_num;
    erStat = inet_pton(AF_INET, IP_SERV, &ip_to_num);
    if (erStat <= 0) {
        cout << "Error in IP translation to special numeric format" << endl;
        return 1;
    }


    WSADATA wsData;
    erStat = WSAStartup(MAKEWORD(2, 2), &wsData);
    if (erStat != 0) {
        cout << "Error WinSock version initializaion #";
        cout << WSAGetLastError();
        return 1;
    }

    //F client
    SOCKET ServSockF = socket(AF_INET, SOCK_STREAM, 0);
    if (ServSockF == INVALID_SOCKET) {
        cout << "Error initialization socket # " << WSAGetLastError() << endl;
        closesocket(ServSockF);
        WSACleanup();
        return 1;
    }


    sockaddr_in servInfoF;
    ZeroMemory(&servInfoF, sizeof(servInfoF));
    servInfoF.sin_family = AF_INET;
    servInfoF.sin_addr = ip_to_num;
    servInfoF.sin_port = htons(PORT_NUMF);
    erStat = ::bind(ServSockF, (sockaddr*)&servInfoF, sizeof(servInfoF));
    if (erStat != 0) {
        cout << "Error Socket binding to server info. Error # " << WSAGetLastError() << endl;
        closesocket(ServSockF);
        WSACleanup();
        return 1;
    }

    

    erStat = listen(ServSockF, SOMAXCONN);
    if (erStat != 0) {
        cout << "Can't start to listen to. Error # " << WSAGetLastError() << endl;
        closesocket(ServSockF);
        WSACleanup();
        return 1;
    }
    else {
        cout << "ListeningF..." << endl;
    }


    sockaddr_in clientInfoF;
    ZeroMemory(&clientInfoF, sizeof(clientInfoF));
    int clientInfo_sizeF = sizeof(clientInfoF);
    SOCKET ClientConnF = accept(ServSockF, (sockaddr*)&clientInfoF, &clientInfo_sizeF);
    if (ClientConnF == INVALID_SOCKET) {
        cout << "ClientА detected, but can't connect to a client. Error # " << WSAGetLastError() << endl;
        closesocket(ServSockF);
        closesocket(ClientConnF);
        WSACleanup();
        return 1;
    }
    else {
        cout << "Connection to a clientF established successfully" << endl;
        char clientIP[22];

        inet_ntop(AF_INET, &clientInfoF.sin_addr, clientIP, INET_ADDRSTRLEN);

        cout << "ClientF connected with IP address " << clientIP << endl;

    }
    //


    //G client
    SOCKET ServSockG = socket(AF_INET, SOCK_STREAM, 0);
    if (ServSockG == INVALID_SOCKET) {
        cout << "Error initialization socket # " << WSAGetLastError() << endl;
        closesocket(ServSockG);
        WSACleanup();
        return 1;
    }

    sockaddr_in servInfoG;
    ZeroMemory(&servInfoG, sizeof(servInfoG));
    servInfoG.sin_family = AF_INET;
    servInfoG.sin_addr = ip_to_num;
    servInfoG.sin_port = htons(PORT_NUMG);
    erStat = ::bind(ServSockG, (sockaddr*)&servInfoG, sizeof(servInfoG));
    if (erStat != 0) {
        cout << "Error Socket binding to server info. Error # " << WSAGetLastError() << endl;
        closesocket(ServSockG);
        WSACleanup();
        return 1;
    }

    erStat = listen(ServSockG, SOMAXCONN);
    if (erStat != 0) {
        cout << "Can't start to listen to. Error # " << WSAGetLastError() << endl;
        closesocket(ServSockG);
        WSACleanup();
        return 1;
    }
    else {
        cout << "ListeningG..." << endl;
    }

    sockaddr_in clientInfoG;
    ZeroMemory(&clientInfoG, sizeof(clientInfoG));
    int clientInfo_sizeG = sizeof(clientInfoG);
    SOCKET ClientConnG = accept(ServSockG, (sockaddr*)&clientInfoG, &clientInfo_sizeG);
    if (ClientConnG == INVALID_SOCKET) {
        cout << "Client G detected, but can't connect to a client. Error # " << WSAGetLastError() << endl;
        closesocket(ServSockG);
        closesocket(ClientConnG);
        WSACleanup();
        return 1;
    }
    else {
        cout << "Connection to a clientG established successfully" << endl;
        char clientIP[22];

        inet_ntop(AF_INET, &clientInfoG.sin_addr, clientIP, INET_ADDRSTRLEN);

        cout << "ClientG connected with IP address " << clientIP << endl;

    }

    //

    vector <char> servBuffF(BUFF_SIZE),servBuffG(BUFF_SIZE);
    short packet_sizeF = 0;
    short packet_sizeG = 0;
    bool finish = false;
    std::thread waitThreadF(wait, std::ref(finish));
    waitThreadF.detach();


         

        packet_sizeF = recv(ClientConnF, servBuffF.data(), servBuffF.size(), 0);	
        packet_sizeG = recv(ClientConnG, servBuffG.data(), servBuffG.size(), 0);
       


        cout << "f(x)= " << servBuffF.data() << endl;
        cout << "g(x)= " << servBuffG.data()<< endl;
    
        if (servBuffF.data() != "soft" && servBuffF.data() != "hard" && servBuffG.data() != "soft" && servBuffG.data() != "hard") {
            if (atof(servBuffF.data()) > atof(servBuffG.data())) {
                cout << "min is g(x)= " << atof(servBuffG.data()) << endl;
            }
            if (atof(servBuffF.data()) < atof(servBuffG.data())) {
                cout << "min is f(x)= " << atof(servBuffF.data()) << endl;
            }
        }
   

 
    
    closesocket(ServSockF);
    closesocket(ClientConnF);
    closesocket(ServSockG);
    closesocket(ClientConnG);
    WSACleanup();

    
    WaitForSingleObject(pi.hProcess, INFINITE);
    CloseHandle(pi.hProcess);
    CloseHandle(pi.hThread);
}


