# SpringRestfulWebServicesExample
SpringRestfulWebServicesExample


Build instructions - 

      This is a maven project and the pom.xml may need versions to be changed for the dependency libraries depending on the repository it 
      is pointing to.
      
 Deployment instructions - 
      Maven build generates a .war file which can be put in the server deployment folder

     
  Testing insrtuctions -
      Any Rest Client can be used to send the requests to the application. Below end points are implemented
      
      Get An Ad
       GET -  http://localhost:8080/SpringRestfulWebServicesExample/hello/ad/partner4
       
       Post an Ad
       POST - http://localhost:8080/SpringRestfulWebServicesExample/hello/ad
               {
                "duration": "400",
                "partnerId": "partner4",
                "adContent": "ad content2"
      }
      
      Get All Ads
      GET - http://localhost:8080/SpringRestfulWebServicesExample/hello/allAds

      
