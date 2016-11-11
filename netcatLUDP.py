import socket


def handlestring(datastring, length, delimiter):
    sep=delimiter
    stringlist=datastring.split(sep)
    fileteredlist=[]
    for string in stringlist:
        fileteredlist.append(string[length :])
    filteredstring = delimiter.join(fileteredlist)
    return filteredstring

def handle(passedconn):
    data = b""
    newdata=passedconn.recv(size)
    while newdata:
        data +=newdata
        newdata= passedconn.recv(size)
    if data:
            datastring= data.decode("utf-8")
            print (handlestring(datastring,len("spam_"), "\n"))
    passedconn.close()

def main():
    s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    s.bind((host,port))
    data,addr=s.recvfrom(1024)
    #s.listen(backlog)
    '''for i in [1,2,3]:
        conn, clientaddress=s.recvfrom(size)
        handle(conn)'''
        
    if data:
        datastring= data.decode("utf-8")
        print (handlestring(datastring,len("spam_"), "\n"))
    s.close()


host = "localhost"
port = 42424
backlog = 5
size = 10204

if __name__=="__main__":
    main()
