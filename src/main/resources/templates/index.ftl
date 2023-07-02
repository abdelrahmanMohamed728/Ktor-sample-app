<#-- @ftlvariable name="quotes" type="kotlin.collections.List<com.example.models.quote>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list quotes?reverse as quote>
        <div>
            <h3>
                <a href="/quotes/${quote.id}">${quote.title}</a>
            </h3>
            <p>
                ${quote.body}
            </p>
        </div>
    </#list>
    <hr>
    <p>
        <a href="/quotes/new">Create quote</a>
    </p>
</@layout.header>