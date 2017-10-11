# alivepush service

## server config
| Server Name     | IP Address    | HostName            |
| --------------- | ------------- | ------------------- |
| 应用服务器02    | 172.16.11.130 | centos_64_02        |
| 应用服务器01    | 172.16.11.132 | centos_64_01        |
| Docker 私有仓库 | 172.16.11.132 | docker private repo |

## servive config
| Service Name | Port      |
| ------------ | --------- |
| registry     | 8761,8762 |
| monitor      | 8080      |
| config       | 8040      |
| api-gateway  | 8003      |
| auth-service | 8004      |
