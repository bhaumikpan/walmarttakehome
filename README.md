WalmartTakeHome project
- where display list of countries from given api on Android devices

ARCHITECTURE

  - Hilt for DI purpose
  - CLEAN ARCH  where feature ui/data/domain is seprated in its module. (to keep sepration of concern)
  - on UI module feaureUI MVVM IS USED with COROUTINE calls to achieve target

This code base contist of following packages/modules

- main - module
  default App laucher activty, onCreate start featureui module activity
- featureui - module
  - view
    - FeatureActivity
    - ListFragment
  - viewmodel
    - FeatureViewModel
  - adapter
    - ListAdapter       
  default activity FeatureActivity shows ListFragment - which observes 2 LiveData - a for list and b for error  
  ListFragment binds Recycleview for displaying list, and FeatureViewModel as viewmodel for api calls
  FeatureViewModel, while init calls FeaureRepo coroutine api to collect list and stores in LiveData
- feature-data
  - has api, di, repo packages
    - api has, FeaureApi, declared which api to call to get list
    - di has, extra stuffs needed for di purposes bind for FeatureApi and FeatureRepo
    - *IMPORTANT* repo has, FeaureRepoImpl provides the implemtation of FeatureRepo
  - has unit test package where FeatureRepoImpl unit testing is done for Success and Error cases 
- feature-domain
  - has model, repository
    - model has data class Country
    - repositoy has FeatureRepo with suspen methos to call api
- netwrok-data
  - has di and extensions
    - di has Dispatcher which give IO dispacture to use with annotation
    - extension has CoreResult for provdies extension of Kotelin Result class with more leverage of Understanding readibility of calls
- analytics
  - extra package for analytics purpose to log (call api) when needed

![alt text](https://github.com/bhaumikpan/walmarttakehome/blob/master/app_screenshot)
 
