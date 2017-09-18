#!/bin/bash

relative_path=/Users/youkai/Documents/workspace/alivepush-service
cd $relative_path
mvn clean package

# registry
registry_jar_path=./registry/target
registry_jar=registry-1.0-SNAPSHOT.jar
cp $registry_jar_path/$registry_jar ./runtime/
echo -e "#!/bin/bash\n cd" $relative_path " \n java -jar ./runtime/"$registry_jar" \n# prevent exiting\nbash">./scripts/modules/registry.sh
chmod +x ./scripts/modules/registry.sh

# monitor
monitor_jar_path=./monitor/target
monitor_jar=monitor-1.0-SNAPSHOT.jar
cp $monitor_jar_path/$monitor_jar ./runtime/
echo -e "#!/bin/bash\n cd" $relative_path " \n java -jar ./runtime/"$monitor_jar" \n# prevent exiting\nbash">./scripts/modules/monitor.sh
chmod +x ./scripts/modules/monitor.sh

# auth-service
auth_service_jar_path=./auth-service/target
auth_service_jar=auth-service-1.0-SNAPSHOT.jar
cp $auth_service_jar_path/$auth_service_jar ./runtime/
echo -e "#!/bin/bash\n cd" $relative_path " \n java -jar ./runtime/"$auth_service_jar" \n# prevent exiting\nbash">./scripts/modules/auth-service.sh
chmod +x ./scripts/modules/auth-service.sh