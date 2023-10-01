#!/bin/bash
kill $(lsof -t -i:5173)
rm -r FrontEnd
unzip FrontEnd.zip
cd FrontEnd
npm install                       
npm run dev
