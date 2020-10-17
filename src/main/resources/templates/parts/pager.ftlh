<#macro pager url page>

    <div>
        <ul class="pagination pagination-sm justify-content-end" style="margin-right: 20%">
            <#assign value = true />
            <#list 1..page.getTotalPages() as p>
                <#if value>
                    <#if (p - 1) lt 0>
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true" style="color: #314A40">&laquo;</span>
                            </a>
                        </li>
                        <#else>
                            <li class="page-item">
                                <a class="page-link" href="${url}?page=${p - 1}&size=${page.getSize()}" aria-label="Previous">
                                    <span aria-hidden="true" style="color: #314A40">&laquo;</span>
                                </a>
                            </li>
                    </#if>
                    <#assign value = false />
                </#if>
                <#if (p - 1) == page.getNumber()>
                    <li class="page-item active"><a class="page-link" style="border-color: #314A40; background-color: #314A40" href="#" tabindex="-1">${p}</a></li>
                <#else>
                    <li class="page-item"><a class="page-link" style="color: #314A40" href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a></li>
                </#if>
            </#list>
            <#if page.getNumber() == page.getTotalPages() - 1>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true" style="color: #314A40">&raquo;</span>
                    </a>
                </li>
            <#else>
                <li class="page-item">
                    <a class="page-link" href="${url}?page=${page.getNumber() + 1}&size=${page.getSize()}" aria-label="Next">
                        <span aria-hidden="true" style="color: #314A40">&raquo;</span>
                    </a>
                </li>
            </#if>
        </ul>
        <ul class="pagination pagination-sm justify-content-end" style="margin-right: 20%">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Элементов на странице</a>
            </li>

            <#if page.getTotalElements() == 1>
                <li class="page-item active" style="background-color: darkgrey"><a class="page-link" style="color: #314A40" href="#" tabindex="-1">1</a></li>
                <#else>
                    <#list [1, 2, page.getTotalElements()] as c>
                        <#if c == page.getSize()>
                            <li class="page-item active"><a class="page-link" style="background-color: #314A40; border-color: #314A40;" href="#" tabindex="-1">${c}</a></li>
                        <#else>
                            <li class="page-item"><a class="page-link" style="color: #314A40" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a></li>
                        </#if>
                    </#list>
            </#if>

            <#--<#list [1, 2] as c>
                <#if c == page.getSize()>
                    <li class="page-item active"><a class="page-link" href="#" tabindex="-1">${c}</a></li>
                <#else>
                    <li class="page-item"><a class="page-link" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a></li>
                </#if>
            </#list>-->
        </ul>
    </div>
</#macro>