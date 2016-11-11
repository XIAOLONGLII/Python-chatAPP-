#I worked with a classmate. He taught me how to understand some parts

import socket
import sys

from socket import*
from random import*


BUFSIZE=1024


def main():
    if len(sys.argv)<3:
        usage()
    myport=eval(sys.argv[1])
    servport=eval(sys.argv[2])
    corrupt=eval(sys.argv[3])

    s = socket(AF_INET,SOCK_DGRAM)
    s.bind(('',myport))
    print('It is listening on %s ' % myport)

    while 1<2:
        data,port=s.recvfrom(BUFSIZE)
        if port[1]!= servport:
            cliport=port[1]
            print('Recieved %r from %r (client)' %(data,port))
            prob=random()*100
            if corrupt>=prob:
                data="corrupt"
            s.sendto(data.upper(),('',servport))
        else:
            print('Recieved %r from %r (client)' %(data,port))

            prob=random()*100
            if corrupt>=prob:
                data="corrupt"

            s.sendto(data.upper(),('',cliport))

def usage():
    sys.stdout=sys.stderr
    print 'Usage: ./undp.py[myport][srvport][corrupt%]'
    sys.exit(2)
if __name__ =="__main__":
    main()
