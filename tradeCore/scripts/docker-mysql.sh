#!/usr/bin/env bash

docker run -p 127.0.0.1:13306:3306 --name trade-mysql -e MYSQL_ROOT_PASSWORD=abcd1234 -d mysql:latest