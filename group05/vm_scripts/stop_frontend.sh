#!/bin/bash
kill $(lsof -t -i:5173)
