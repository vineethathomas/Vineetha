# vineetha
**String Sorting Java Project**

Takes as a parameter a string that represents a text file containing a list of names.
Orders the names by last name followed by first name.
Creates a new text file called input file name-sorted.txt with the list of sorted names.

Spring **4.3.4** with build tool as **Apache Maven** is used for implementation of the functionality

**Main Classes:**
1. AppConfig.java - Configuration class, [see here](https://github.com/vineethathomas/Vineetha/tree/master/String-Sorting/src/main/java/com/string/sorting/config)
2. ApplicationController.java - MAin class, [see here](https://github.com/vineethathomas/Vineetha/tree/master/String-Sorting/src/main/java/com/string/sorting/controller)
3. Name.java - Model class, [see here](https://github.com/vineethathomas/Vineetha/tree/master/String-Sorting/src/main/java/com/string/sorting/model)
4. AppService.java - Service interface, [see here](https://github.com/vineethathomas/Vineetha/tree/master/String-Sorting/src/main/java/com/string/sorting/service)
5. AppServiceImpl.java - Service implementation class

**Testcases:**
Used **SpringJUnit4ClassRunner** for implementation of testcase

class name: AppServiceTest.java, [see here](https://github.com/vineethathomas/Vineetha/tree/master/String-Sorting/src/test/java/com/string/sorting/service)

**Build Project:**

Builds automatically for every git push in **travis**, [My Travis](https://travis-ci.org/vineethathomas/Vineetha)

**Build file for travis:**

.travis.yml, [see here](https://github.com/vineethathomas/Vineetha/blob/master/.travis.yml)


