<#ftl encoding='UTF-8'>
<#import "spring.ftl" as spring />
<@spring.bind "model" />
<!DOCTYPE html>
<head>
    <title>Пользователи</title>
<link rel="stylesheet" type="text/css" href="/resources/list.css">
</head>
<body>
<ul class="drop_down_list">
<#list model.users as user>
    <li>${user.name}</li>
    <li>${user.mail}</li>
    <ul>
        <#list user.accounts as account>
            <li>${account.account}</li>
        </#list>
    </ul>
</#list>
</ul>
</body>