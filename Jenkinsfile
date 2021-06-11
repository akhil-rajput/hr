node{  
  stage('SCM checkout'){
    
   bat'git clone https://github.com/akhil-rajput/hr' 
   
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
