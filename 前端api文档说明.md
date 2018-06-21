## 电影信息管理系统前端api文档说明

登录机制再进行商量，如果时间来不及就不做登陆机制了。

按照页面的文件名字来进行说明。

项目前端结构说明：

每个页面都可以看做是一个jsp，虽然有一些页面用不到jsp的功能，但是为了方便起见都弄成了jsp，只有一个页面是html。

前端页面都在web文件夹中，index.jsp和登陆的页面在web文件夹下，其他页面都在web文件夹下的film文件夹下，web文件下除了jsp文件和html文件其他都为js、css和图片文件均为修饰页面用，与后台无关。

目前页面显示的所有数据都是前端直接显示的示例拿来测试用，与后台无关。

按照页面的文件名字来进行页面功能和表单提交参数和按钮功能的说明：

##### 1、index.jsp

无特殊说明。

##### 2、actorQuery.jsp

页面功能：按照姓名查找演员资料，查找的资料包括姓名、出生日期、参演电影以及在电影中的角色。

表单提交参数：

```
{
    actorname:演员姓名
}
```

##### 3、actorQueryResult.jsp

页面功能：显示actorQuery.jsp查询后的结果。

##### 4、alterFilmIndex.jsp

页面功能：电影信息管理的初始页面，按钮从上到下从左右依次跳转到：

```
FilmOtherChangeQuery.jsp
film_insert.jsp
film_delete.jsp
film_update.jsp
changeindex.html
```

页面左边为显示的表格，需从后台获取数据。

##### 5、chengeindex.html

页面功能：信息管理的初始页面，按钮从左到右依次跳转到：

```
alterFilmIndex.jsp
PersonIndex.jsp
FirmIndex.jsp
KindManage.jsp
../index.jsp
```

##### 6、directorQuery.jsp

页面功能：按照名字查找导演资料，查找的资料包括姓名、出生日期、导演的所有电影。

表单提交参数：

```
{
	directorname:导演姓名
}
```

##### 7、directorQueryResult.jsp

页面功能：显示directorQuery.jsp查询后的结果。

##### 8、film_delelte.jsp

页面功能：按照电影编号和电影名称删除一条电影记录。

表单提交参数：

```
{
    FilmnID:电影编号
    Filmname:电影名称
}
```

删除记录按钮提交表单。

返回内容：

~~~:
{
    action:
    	/FilmDelete
    setAttribute:
    	affectRows:改变行数
    	resultInfo:结果信息(成功或失败)
}
~~~



返回按钮跳转alterFilmIndex.jsp。

##### 9、film_insert.jsp

页面功能：插入一条电影记录。

表单提交参数：

```
{
    Filmname:电影名称
    date:发行日期
    FilmLengt:电影时长
    Firm:出品公司
    FilmPlot:电影简介
}
```

电影编号在插入时系统自动生成。

添加记录按钮提交表单。

返回内容：

~~~:
{
    action:
    	/FilmInsert
    setAttribute:
    	affectRows:改变行数
    	insertInfo:插入结果信息(成功或失败)
}
~~~



返回按钮跳转alterFilmIndex.jsp。

##### 10、film_update.jsp

页面功能：按照编号更新一条电影记录。

表单提交参数

```
{
    FilmID:电影编号
    Filmname:电影名称
    date:发行日期
    FilmLengt:电影时长
    Firm:出品公司
    FilmPot:电影简介
}
```

修改记录按钮提交表单。

返回内容：

~~~：
{
    action:
    	/FilmUpdate
    setAttribute:
    	affectRows:改变行数
    	updateInfo:修改结果信息(成功或失败)
}
~~~

返回按钮跳转alterFilmIndex.jsp。

##### 11、FilmActorChange.jsp

页面功能：管理一部电影的演员信息。

表单提交参数：

```
添加和删除表单：
{
    id:判断是添加还是删除，如果为1则是添加，如果为2则是删除
    FilmID:电影ID
    Filmactor:演员姓名
    Filmrole:扮演角色
    
    action:
    	/FilmActorChange
}
演员角色修改表单：
{
	FilmID:电影ID
    Filmactor0:原演员姓名
    Filmrole0:原扮演角色
    Filmactor1:现演员姓名
    Filmrole1:现扮演角色
    
    action:
    	/FilmActorUpdate
}

```

添加和删除按钮提交添加和删除表单。

上修改按钮提交修改角色表单。

下修改按钮提交修改演员表单。

返回按钮跳转FilmOtherChangeQuery.jsp

##### 12、filmCategoryQueryResult.jsp

页面功能：按照类别查询电影，查询的数据包括此类别下的所有电影名称。

返回按钮返回queryindex.jsp。

##### 13、FilmDirectorChange.jsp

页面功能：管理一部电影的导演信息。

表单提交参数：

```
添加和删除表单：
{
    id:判断是添加还是删除，如果为1则是添加，如果为2则是删除
    Filmdirector:导演姓名
    FilmID:电影ID
    
    action:
    	/FilmDirectorChange
}
修改表单：
{
	FilmID：电影ID
    Filmdirector_cpre:导演姓名
    Filmdirector_clate:修改后的导演姓名
    
    action:
		/FilmDirectorUpdate
}
```

添加和删除按钮提交添加和删除表单。

修改按钮提交修改表单。

返回按钮跳转FilmOtherChangeQuery.jsp

##### 14、FilmKindChange.jsp

页面功能：管理一部电影的种类信息。此页面的表单应该做成下拉框，但是不知道什么原因现在无法实现。如果有时间再进行研究。是否加下拉框不影响后台处理。

表单提交参数：

```
添加和删除表单：
{
    id:判断是添加还是删除，如果为1则是添加，如果为2则是删除
    FilmID:电影ID
    Filmkind:类别
    
    action:
    	/FilmCategoryChange
}
修改表单：
{
	FilmID:电影ID
    Filmkind_cpre:修改前的类别
    Filmkind_clate:修改后的类别
    
    action:
    	/FilmCategoryUpdate
}
```

添加和删除按钮提交添加和删除表单。

修改按钮提交修改表单。

返回按钮跳转FilmOtherChangeQuery.jsp

##### 15、FilmNameQueryResult.jsp

页面功能：按照名称查询电影，查询的数据包括此电影的姓名、出品日期、电影时长、出品公司、电影导演、电影演员及其饰演角色、电影简介。

~~~:
{
    List<Film> filmList
}
~~~



返回按钮返回queryindex.jsp。

##### 16、FilmOtherChangeQuery.jsp

页面功能：查询要管理的电影，管理其导演、演员、旁白和类别。

表单提交参数：

```
{
    id:判断其是管理导演、演员、旁白还是类别，如果为1则管理导演，对应FilmDirectorChange.jsp；如果为2则管理演员，对应FilmActorChange.jsp；如果是3则管理旁白，对应FilmVoiveChange.jsp；如果是4管理类别，对应FilmKindeChange.jsp。
    FilmName:电影名称
    FilmID:电影编号
    
    action:
    	/FilmQuery
}
```

返回按钮返回alterFilmIndex.jsp。

##### 17、FilmQuery.jsp

页面功能：按照名称或者类型查询电影。

表演提交参数：

```
按名称查询：
{
    Filmname:电影名称
}
按类别查询：
{
    kind:类别
}

	action:
		/FilmQuery
```

两种表单查询分别对应filmNameQueryResult.jsp、filmCategoryQueryResult.jsp。

##### 18、FilmVoiceChange.jsp

页面功能：管理一部电影的旁白信息。

表单提交参数：

```
添加和删除表单：
{
    id:判断是添加还是删除，如果为1则是添加，如果为2则是删除
    FilmID：电影ID
    Filmvoice:旁白姓名
    
    action:
    	/FilmVoiceChange
}
修改表单：
{
	FilmID:电影ID
    Filmvoice_cpre:旁白姓名
    Filmvoice_clate:修改后的旁白姓名
    
    action:
    	/FilmVoiceUpdate
}
```

添加和删除按钮提交添加和删除表单。

修改按钮提交修改表单。

返回按钮跳转FilmOtherChangeQuery.jsp

##### 19、FirmIndex.jsp

页面功能：管理出品公司的信息。

表单提交参数：

```
添加公司表单：
{
    firm_name_insert:要插入的公司名称
    firm_city_insert:要插入的所在城市
    
    action:
    	/FirmInsert
}
修改公司表单：
{
    firm_num_upn:要修改的公司编号
    firm_name_up:修改后的公司名称
    city:修改后的公司城市
    
    action:
    	/FirmUpdate
}

删除公司表单：
{
    firm_num_delete:要删除的公司编号
    firm_name_delete:要删除的公司名称
    
    action:
    	/FirmDelete
}
```

每个按钮以此对应上述表单。

返回按钮返回changeindex.html。

##### 20、firmQuery：

页面功能：按名称查询一个出品公司的信息。

表单提交参数：

```
{
    firmname:公司名称
    
    action:
    	/FirmQuery
}
```

对应firmQueryResult.jsp。

##### 21、firmQueryResult.jsp

页面功能：按照名称查询一个出品公司，返回的信息包括公司名、所在城市和出品的全部电影。

返回参数

~~~:
Firm firm;
~~~



返回按钮返回queryindex.jsp。

##### 22、KindManage.jsp

页面功能：管理电影的类别。

表单提交参数：

```
修改类别表单：
{
    kindc_pre:要修改的类别
    kindc_late:修改后的类别
    
    action:
    	/CategoryUpdate
}
添加类别表单：
{
    kind:要添加的类别
    
    action:
    	/CategoryInsert
}
删除类别表单：
{
    kind_delete:要删除的类别
    
    action:
    	/CategoryDelete
}
```

每个按钮以此对应上述表单。

返回按钮返回changeindex.html。

##### 23、PersonIndex.jsp

页面功能：管理人物的基本信息，包括编号、姓名、生日。

表单提交参数：

```
添加人物表单：
{
    person_name_insert:要添加的人物姓名
    person_date_insert:要添加的人物出生日期
}
修改姓名表单：
{
    person_num_upn:要修改姓名的人物编号
    person_name_up:修改后的人物姓名
}
修改生日表单：
{
    person_num_upb:要修改生日的人物编号
    person_date_up:修改后的人物出生日期
}
删除人物表单：
{
    person_num_delete:要删除的人物编号
    person_name_delete:要删除的人物姓名
}
```

每个按钮以此对应上述表单。

返回按钮返回changeindex.html。

##### 24、queryindex.jsp

无特殊说明。

##### 25、voice_Query.jsp

页面功能：按照人物姓名查询旁白。

表单提交参数：

```
{
    voicename:旁白姓名
}
```

对应voice_QueryResult.jsp。

##### 26、voice_QueryResult.jsp

页面功能：按照姓名查询旁白，包括其生日和旁白的所有电影。

返回按钮返回queryindex.jsp。

### 27、ErrorOutput.jsp

页面功能：返回错误信息

~~~java
返回参数列表及用途：
Boolean isTrue;				//是否正确
Boolean isExisted;			//是否重复，1为重复，0为对象不存在
String errorObject;			//出错对象，如Film,Person
	{"Film","Actor","Voice","Director"}
String errorOperation;		//操作类型，判断不成功的操作是插入、修改、删除的哪一个
~~~

