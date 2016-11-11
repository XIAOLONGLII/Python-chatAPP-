#lab5
import socket
import sys
from socket import*
from random import*

BUFSIZE =1024

#myport= 42425
#host="localhost"
#listenerport=42424

def main():
     if len(sys.argv)< 3:
          usage()
     myport =eval(sys.argv[1])
     servport=eval(sys.argv[2])
     corrupt=eval(sys.argv[3])
    
#bind
     s = socket(AF_INET,SOCK_STREAM)
     s.bind(('',myport))
     
     print ('it is listening on &s' % myport)
     while 1<2:
          data, port=s.recvfrom(BUFSIZE)
          if port[1]!=servport:
               cliport=port[1]
               print'Recieved %r from %r (client)' %(data,port)
               probility =random()*100
               if corrupt>=probility:
                    data="corrupt"
               s.sendto(data.upper(), ('',servport))
          else:
               print'Recieved %r from %r (server)'%(data,port)
               probility =random()*100
               if corrupt>=probility:
                    data ="corrupt"

               s.sendto(data.upper(),('',cliPort))
     if corrupt:
          sendto(ack)
     else if corrupt!:
          sendto(ack)
     else:
          null;


def usage():
    sys.stdout=sys.stderr
    print 'Usage: ./undp.py [my port][srv port][corrupt%]'
    sys.exit(2)
if __name__=="__main_":
    main() 
