#!/bin/bash
nohup ./start_cronjob.sh > ./cron.out 2> ./cron.err < /dev/null &
