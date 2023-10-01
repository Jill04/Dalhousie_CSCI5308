#!/bin/bash
rm -r server
unzip server.zip 
cd server
npm install                      
npm run build                    
npm run start
