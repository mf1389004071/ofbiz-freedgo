/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import org.ofbiz.entity.condition.EntityCondition
import org.ofbiz.entity.condition.EntityOperator

conditionList = []
if (fromDate) {
    conditionList.add(EntityCondition.makeCondition("fromDate", EntityOperator.GREATER_THAN_EQUAL_TO, fromDate))
}
if (statusDate) {
    conditionList.add(EntityCondition.makeCondition("statusDate", EntityOperator.GREATER_THAN_EQUAL_TO, statusDate))
}
if (thruDate) {
    conditionList.add(EntityCondition.makeCondition("fromDate", EntityOperator.LESS_THAN_EQUAL_TO, thruDate))
}
if (contactListId) {
    conditionList.add(EntityCondition.makeCondition("contactListId", EntityOperator.EQUALS, contactListId))
}
if (statusId) {
    conditionList.add(EntityCondition.makeCondition("statusId", EntityOperator.EQUALS, statusId))
}
conditions = EntityCondition.makeCondition(conditionList, EntityOperator.AND)
partyStatusLists = delegator.findList("ContactListPartyStatus", conditions, null, null, null, false)
context.partyStatusLists = partyStatusLists
