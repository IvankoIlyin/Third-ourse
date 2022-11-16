#include <type_traits>
#include <iostream>
#include "trialfuncs.hpp"
#include <Winsock2.h>
#include <WS2tcpip.h>
#include <stdio.h>
#include <vector>
#include <future>
#pragma comment(lib, "Ws2_32.lib")
using namespace std;

void wait(bool& softFail) {
    Sleep(10000);
    softFail = true;
}
void f(std::variant<os::lab1::compfuncs::hard_fail, os::lab1::compfuncs::soft_fail, double>& result, double x, bool& ready) {
    result = os::lab1::compfuncs::trial_f<os::lab1::compfuncs::DOUBLE_MULT>(x);
    ready = true;
}


string func(double x) {
   
    std::string s;
    int tryCount = 0;
    bool softFail = false;
    std::variant<os::lab1::compfuncs::hard_fail, os::lab1::compfuncs::soft_fail, double> result;
    do {
        softFail = false;
        bool ready = false;
        std::thread threadF(f, std::ref(result), x, std::ref(ready));
        threadF.detach();
        std::thread waitThreadF(wait, std::ref(softFail));
        waitThreadF.detach();
        
        while (true) {
            std::cout << "";
            if (ready == true || softFail == true) {
                break;
            }
        }
        if (softFail) {
            result = os::lab1::compfuncs::soft_fail();
        }
        switch (result.index())
        {
        case 0: s = "hard"; break;
        case 1: s = "soft"; break;
        case 2: s = std::to_string(std::get<2>(result)); break;

        }
        tryCount++;
    } while (result.index() == 1 && tryCount != 5);

    return s;
        
}



int main(int argc, char* argv[])    
{
   



    //Client
    const char SERVER_IP[] = "192.168.1.107";
    const short SERVER_PORT_NUM = 1488;
    const short BUFF_SIZE = 1024;

    int erStat;
    in_addr ip_to_num;
    inet_pton(AF_INET, SERVER_IP, &ip_to_num);

    WSADATA wsData;
    erStat = WSAStartup(MAKEWORD(2, 2), &wsData);
    if (erStat != 0) {
        cout << "Error WinSock version initializaion #";
        cout << WSAGetLastError();
        return 1;
    }


    SOCKET ClientSock = socket(AF_INET, SOCK_STREAM, 0);
    if (ClientSock == INVALID_SOCKET) {
        cout << "Error initialization socket # " << WSAGetLastError() << endl;
        closesocket(ClientSock);
        WSACleanup();
    }


    sockaddr_in servInfo;

    ZeroMemory(&servInfo, sizeof(servInfo));

    servInfo.sin_family = AF_INET;
    servInfo.sin_addr = ip_to_num;
    servInfo.sin_port = htons(SERVER_PORT_NUM);

    erStat = connect(ClientSock, (sockaddr*)&servInfo, sizeof(servInfo));
    
    if (erStat != 0) {
        cout << "Connection to Server is FAILED. Error # " << WSAGetLastError() << endl;
        closesocket(ClientSock);
        WSACleanup();
        //return 0;
    }
    else
        cout << "Connection established SUCCESSFULLY." << endl;




    double x = atof(argv[0]);
    string f = func(x);
    char const* ans = f.c_str();
    short packet_size = 0;
    packet_size = send(ClientSock, ans, sizeof(ans), 0);
        
    if (packet_size == SOCKET_ERROR) {
            cout << "Can't send message to Server. Error # " << WSAGetLastError() << endl;
            closesocket(ClientSock);
            WSACleanup();
            return 1;
        }
 
    closesocket(ClientSock);
    WSACleanup();
    //
}

