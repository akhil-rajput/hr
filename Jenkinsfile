node{  
  stage('SCM checkout'){
    
   git'https://github.com/akhil-rajput/hr/' 
   
  }
  
 stage ('Compile Stage') {

bat'mvn clean compile'


 }
  stage('test stage'){
bat'mvn test'
}
  
  
stage ('Install Stage') {
bat'mvn install'
}


}
