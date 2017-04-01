<#--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->
<#escape x as x?xml>
<fo:table table-layout="fixed" width="100%" space-after="0.3in">
    <fo:table-column column-width="3.5in"/>
    <fo:table-body>
        <fo:table-row>
            <fo:table-cell>
                <fo:block>${uiLabelMap.CommonTo}:</fo:block>
                <#if billingAddress?has_content>
                    <#assign billingPartyNameResult = dispatcher.runSync("getPartyNameForDate", Static["org.ofbiz.base.util.UtilMisc"].toMap("partyId", billingParty.partyId, "compareDate", invoice.invoiceDate, "userLogin", userLogin))/>
                    <fo:block>${billingPartyNameResult.fullName?default(billingAddress.toName)?default("Billing Name Not Found")}</fo:block>
                    <#if billingAddress.attnName?exists>
                        <fo:block>${billingAddress.attnName}</fo:block>
                    </#if>
                    <fo:block>${billingAddress.address1?if_exists}</fo:block>
                    <#if billingAddress.address2?exists>
                        <fo:block>${billingAddress.address2}</fo:block>
                    </#if>
                    <fo:block>
                        <#if billingAddress.stateProvinceGeoId?has_content>
                            <#assign stateProvince = billingAddress.getRelatedOneCache("StateProvinceGeo")>
                                ${stateProvince.abbreviation?default(stateProvince.geoId)}
                        </#if>
                        <#if billingAddress.city?has_content>
                            <#assign city = billingAddress.getRelatedOneCache("CityGeo")>
                        <#if city?exists>
                            ${city.get("geoName", locale)?default(city.geoId)}
                        </#if>
                    </#if>
                    <#if billingAddress.countyGeoId?has_content>
                        <#assign county = billingAddress.getRelatedOneCache("CountyGeo")>
                        ${county.get("geoName", locale)?default(county.geoId)}
                    </#if>
                    </fo:block>
                <#else>
                    <fo:block>${uiLabelMap.AccountingNoGenBilAddressFound}${billingParty.partyId}</fo:block>
                </#if>
            </fo:table-cell>
        </fo:table-row>
    </fo:table-body>
</fo:table>
</#escape>
