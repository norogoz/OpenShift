App is ready to contain with S2I: https://github.com/openshift/source-to-image

S2I is OpenShift tool used to derive docker images from app source code. It accesses pom.xml (or .war file) and user prepared scripts in order to build the app. Necessary scripts, additional dependencies and configurations can be collected in builder images and used to further simplify user effort.

Builder image I used for this repo comes from OpenShift S2I Community: https://github.com/openshift-s2i/s2i-wildfly  
The image is called openshift/wildfly-160-centos7 and available on DockerHub.

After installing Docker and S2I tool, project can be contained, ran and tested with following commands:

docker pull openshift/wildfly-160-centos7  
s2i build git://github.com/norogoz/OpenShift openshift/wildfly-160-centos7 [image_name]  
docker run -p 8080:8080 [image_name]  
curl localhost:8080/calculate/2*3  
