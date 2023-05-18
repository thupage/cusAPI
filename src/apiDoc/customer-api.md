# Customer Admin API

1. [Get List of Customer API](#get-list-of-customer-api)
1. [Get Detail of Customer API](#get-detail-of-customer-api)
1. [Update Customer's Status API](#update-customers-status-api)
1. [Send Request Update Profile API](#send-request-update-profile-api)
1. [Get List Request Profile API](#get-list-request-profile-api)
1. [Get Detail Request Profile API](#get-detail-request-profile-api)
1. [Update Request Profile API](#update-request-profile-api)
1. [Approver Request Edit Customer API](#approver-request-edit-customer-api)
1. [Reject Request Edit Customer API](#reject-request-edit-customer-api)

## Common

### Request Header

- Content-Type: application/json
- Accept-Charset: UTF-8
- Accept-Language:
  - en-US
  - vi-VN
- Authorization: Bearer `user's token`

### Abnormal Response

- Status code:
  - 401 (UNAUTHORIZED)
  - 403 (FORBIDDEN)

|Code|Message|Description|
|:----|:----|:----|
|unauthorized|Unauthorized|The client requesting the resource but not authorized yet.|
|forbidden|Forbidden|The client does not have access rights to the content; that is, it is unauthorized.|

## Get List of Customer API

### Request

- URI: /management/customer
- Method: GET

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer`

#### Query Parameter

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|first_name|First name|string|Nguyen Van|
|last_name|Last name|string|A|
|id_card_no|ID card number|string|351111222|
|dob_start_date|Date of Birth Start Date|string|23/01/1989 00:00:00|
|dob_end_date|Date of Birth End Date|string|24/01/1989 00:00:00|
|phone|Customer's Phone Number|string|0123456789|
|email|Customer's Email|string|`abc@gmail.com`|
|street|Street|string|14/12 Duong Ky Dong|
|ward_id|Ward's ID|number|55|
|district_id|District's ID|number|1|
|province_id|Province's ID|number|2|
|agency_id|Agency's ID (This filter works only for Tokio Marine admin)|number|2|
|page|Page Number|number|1|
|item_per_page|Item Per Page|number|10|
|sort_key|[Customer List Sort Key](#customer-list-sort-key)|string|customer_name|
|sort_direction|[Sort Direction](#sort-direction)|string|desc|

### Response

#### Normal

- Status code:
  - 200 (OK)

##### Body

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|item_count|Item count|number|1|
|result|[Customer](#customer) list|array||

##### Customer

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Customer's ID|number|66|
|first_name|First name|string|Nguyen Van|
|last_name|Last name|string|A|
|id_card_no|ID card number|string|351111222|
|dob|Date of birth|string|23/01/1989 00:00:00|
|phone|Customer's Phone Number|string|0123456789|
|email|Customer's Email|string|`abc@gmail.com`|
|user_name|Username|string|thanhhnn|
|status|Account status|string|unlock|
|address|[Address](#address)|object||
|nationality|[Nationality](#nationality)|object||
|occupation|[Occupation](#occupation)|object||
|married|[Married status](#married-status)|string|single|
|passport_no|Passport number|string|C1234567|
|agency|[Agency](#agency)|object||

##### Address

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|street|Street|string|14/12 Duong Ky Dong|
|ward|[Ward](#ward)|object||
|district|[District](#district)|object||
|province|[Province](#province)|object||

##### Province

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Province's ID|number|2|
|name|Province's Name|string|Ho Chi Minh|

##### District

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|District's ID|number|3|
|name|District's Name|string|District 3|

##### Ward

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Ward's ID|number|4|
|name|Ward's Name|string|Ward 9|

##### Nationality

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Nationality's ID|number|1|
|name|Nationality's Name|string|Viet Nam|

##### Occupation

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Occupation's ID|number|1|
|name|Occupation's Name|string|Security|

##### Agency

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Agency identify|number|2|
|name|Agency name|string|TokioMarine Việt Nam|

##### Sample Response

```json
{
  "item_count": 2,
  "result": [
    {
      "id": 1,
      "first_name": "Dao",
      "last_name": "Kha Tinh",
      "id_card_no": "351111222",
      "dob": "23/01/1992 00:00:00",
      "phone": "123456789",
      "email": "abc@gmail.com",
      "user_name": "TinhDK",
      "status": "unlock",
      "address": {
        "street": "14/12 Duong Ky Dong",
        "ward": {
          "id": 4,
          "name": " Cống Vị"
        },
        "district": {
          "id": 1,
          "name": " Ba Đình"
        },
        "province": {
          "id": 1,
          "name": "TP.  Hà Nội"
        }
      },
      "nationality": {
        "id": 77,
        "name": "Albanian"
      },
      "occupation": {
        "id": 1,
        "name": "Security"
      },
      "married": "single",
      "passport_no": "C123456789",
      "agency": {
        "id": 2,
        "name": "TokioMarine Việt Nam"
      }
    },
    {
      "id": 2,
      "first_name": "A",
      "last_name": "Nguyen Van",
      "id_card_no": "112459781",
      "dob": "29/02/1999 00:00:00",
      "phone": "987654321",
      "email": "xyz@gmail.com",
      "user_name": "Abcxyz",
      "status": "lock",
      "address": {
        "street": "113 Abc xyz",
        "ward": {
          "id": 3,
          "name": " Tôn Đản"
        },
        "district": {
          "id": 1,
          "name": " Phường 123"
        },
        "province": {
          "id": 1,
          "name": "TP.  HCM"
        }
      },
      "nationality": {
        "id": 77,
        "name": "Albanian"
      },
      "occupation": {
        "id": 1,
        "name": "Security"
      },
      "married": "single",
      "passport_no": "C123456789",
      "agency": {
        "id": 2,
        "name": "TokioMarine Việt Nam"
      }
    }
  ]
}
```

## Get Detail of Customer API

### Request

- URI: /management/customer/{id}
- Method: GET

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer/1`

#### Path Parameter

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Customer's Identify|number|1|

### Response

#### Normal

- Status code:
  - 200 (OK)

##### Body

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Customer's ID|string|1|
|first_name|First name|string|A|
|last_name|Last name|string|Nguyen Van|
|id_card_no|ID card number|string|351111222|
|dob|Date of Birth|string|23/01/1989 00:00:00|
|gender|[Gender](#gender)|string|male|
|phone|Telephone number|string|0123456789|
|email|Email address|string|`sample.email@dummy.com`|
|user_name|Username|string|thanhhnn|
|status|Account status|string|UNLOCK|
|address|[Address](#address)|object||
|nationality|[Nationality](#nationality)|object||
|occupation|[Occupation](#occupation)|object||
|married|[Married status](#married-status)|string|single|
|passport_no|Passport number|string|C1234567|
|agency|[Agency](#agency)|object||

##### Agency

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Agency identify|number|2|
|name|Agency name|string|TokioMarine Việt Nam|

#### Sample Response

```json
{
  "id": "1",
  "first_name": "A",
  "last_name": "Nguyen Van",
  "id_card_no": "351111222",
  "dob": "23/01/1989 00:00:00",
  "gender": "male",
  "phone": "0123456789",
  "email": "sample.email@dummy.com",
  "user_name": "vinh12344",
  "status": "unlock",
  "address": {
    "street": "14/12 Duong Ky Dong",
    "ward": {
      "id": 6603,
      "name": "Trà Bui"
    },
    "district": {
      "id": 515,
      "name": "Bắc Trà My"
    },
    "province": {
      "id": 49,
      "name": "Quảng Nam"
    }
  },
  "nationality": {
    "id": 265,
    "name": "Vietnamese"
  },
  "occupation": {
    "id": 1,
    "name": "Security"
  },
  "married": "single",
  "passport_no": "C123456789",
  "agency": {
    "id": 2,
    "name": "TokioMarine Việt Nam"
  }
}
```

## Send Request Update Profile API

### Request

- URI: /management/customer/temporary
- Method: POST

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer/temporary`

#### Body Parameter

|Required|Name|Description|Type|Example|
|:---|:---|:---|:---|:---|
|〇|id|Profile Id|number|1|
|〇| |User Id|number|1|
|〇|first_name|First Name|string|Tran|
|〇|last_name|Last Name|string|Quang|
|〇|id_card_no|ID Card No|string|123456|
|〇|dob|Dob|string|30/03/1994 00:00:00|
|〇|gender|[Gender](#gender)|string|male|
|〇|phone|Telephone number|string|012345|
|〇|email|Ward's ID|number|4|
|〇|street|Street's|string|Abc|
|〇|nationality|Nationality's ID|number|1|
|〇|occupation|Occupation's ID|number|1|
|〇|passport_no|Passport number|string|C1234567|
|〇|ward_id|Ward's ID|number|1|
||married|[Married status](#married-status)|string|single|


##### Sample Body

```json
{
  "id": 1,
  "first_name": "A",
  "last_name": "Nguyen Van",
  "id_card_no": "351111222",
  "dob": "23/01/1989 00:00:00",
  "gender": "male",
  "phone": "0123456789",
  "email": "sample.email@dummy.com",
  "street": "14/12 Duong Ky Dong",
  "ward_id": 4,
  "nationality": 1,
  "occupation": 1,
  "married": "single",
  "passport_no": "C123456789"
}
```

### Response

#### Normal

- Status code:
   - 200 (OK)

### Abnormal

- Status code:
  - 400 (BAD_REQUEST)
  - 404 (NOT_FOUND)

|Code|Message|Description|
|:----|:----|:----|
|first_name_required|Can not be empty.|The error occurs when `First Name` is empty.|
|first_name_maxlength|Length must be less than 60.|The error occurs when the length of `First Name` is exceeded.|
|last_name_required|Can not be empty.|The error occurs when `Last Name` is empty.|
|last_name_maxlength|Length must be less than 60.|The error occurs when the length of `Last Name` is exceeded.|
|id_card_no|Can not be empty.|The error occurs when `ID card number` is empty.|
|id_card_maxlength|Length must be less than 24.|The error occurs when the length of `ID card number` is exceeded.|
|dob_required|Can not be empty.|The error occurs when `Date of Birth` is empty.|
|dob_invalid|Invalid Date format.|The error occurs when `Date of Birth` is invalid. (a valid `dob` must be formatted in `DD/MM/YYYY HH:MM:SS`)|
|gender_required|Can not be empty.|The error occurs when `Gender` is empty.|
|gender_invalid|Gender is invalid.|The error occurs when `Gender` is invalid. (valid Gender is defined at [Gender](#gender))|
|phone_required|Can not be empty.|The error occurs when `Phone` is empty.|
|phone_invalid|Invalid Phone Number format.|The error occurs when `Phone` is invalid. (a valid phone number must contains 10 or 11 digit)|
|email_required|Can not be empty.|The error occurs when `Email` is empty.|
|email_invalid|Invalid Email format.|The error occurs when `Email` is invalid. [Valid email address format](#valid-email-address-format)|
|street_required|Can not be empty.|The error occurs when `Address's Street` is empty.|
|street_maxlength|Length must be less than 60.|The error occurs when the length of `Address's Street` is exceeded.|
|ward_required|Can not be empty.|The error occurs when `Address's Ward` is empty.|
|nationality_required|Can not be empty.|The error occurs when `Nationality` is empty.|
|occupation_required|Can not be empty.|The error occurs when `Occupation` is empty.|
|passport_no_required|Can not be empty.|The error occurs when `Passport number` is empty.|
|passport_no_maxlength|Length must be less than 24.|The error occurs when the length of `Passport number` is exceeded.|

#### Sample Response

```json
{
  "errors": [
    {
      "code": "email_required",
      "message": "Can not be empty."
    },
    {
      "code": "phone_required",
      "message": "Can not be empty."
    }
  ]
}
```

## Get List Request Profile API

### Request

- URI: /management/customer/temporary
- Method: GET

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer/temporary`

#### Query Parameter

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|ID|number|1|
|first_name|First name|string|Nguyen Van|
|last_name|Last name|string|A|
|id_card_no|ID card number|string|351111222|
|dob_start_date|Date of Birth Start Date|string|23/01/1989 00:00:00|
|dob_end_date|Date of Birth End Date|string|24/01/1989 00:00:00|
|phone|Customer's Phone Number|string|0123456789|
|email|Customer's Email|string|`abc@gmail.com`|
|street|Street|string|14/12 Duong Ky Dong|
|ward_id|Ward's ID|number|55|
|create_user|User's Create ID|number|55|
|page|Page Number|number|1|
|item_per_page|Item Per Page|number|10|
|sort_key|[Customer Temporary list Sort Key](#customer-temporary-list-sort-key)|string|customer_name|
|sort_direction|[Sort Direction](#sort-direction)|string|desc|

### Response

#### Normal

- Status code:
  - 200 (OK)

##### Body

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|item_count|Item count|number|1|
|result|[Customer](#customer) list|array||

##### Customer

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|request_id|Request's ID|number|66|
|id|Customer's ID|number|66|
|first_name|First name|string|Nguyen Van|
|last_name|Last name|string|A|
|id_card_no|ID card number|string|351111222|
|dob|Date of birth|string|23/01/1989 00:00:00|
|phone|Customer's Phone Number|string|0123456789|
|email|Customer's Email|string|`abc@gmail.com`|
|status|Account status|string|unlock|
|address|[Address](#address)|object||
|nationality|[Nationality](#nationality)|object||
|occupation|[Occupation](#occupation)|object||
|married|[Married status](#married-status)|string|single|
|passport_no|Passport number|string|C1234567|
|create_user|Create User|number|1|
|create_time|Create Time|string|23/01/1989 00:00:00|
|create_by|Create By|string|Tran Van A|

##### Sample Response

```json
{
  "item_count": 2,
  "result": [
    {
      "request_id": 1,
      "id": 1,
      "first_name": "Dao",
      "last_name": "Kha Tinh",
      "id_card_no": "351111222",
      "dob": "23/01/1992 00:00:00",
      "phone": "123456789",
      "email": "abc@gmail.com",
      "user_name": "TinhDK",
      "status": "unlock",
      "address": {
        "street": "14/12 Duong Ky Dong",
        "ward": {
          "id": 4,
          "name": " Cống Vị"
        },
        "district": {
          "id": 1,
          "name": " Ba Đình"
        },
        "province": {
          "id": 1,
          "name": "TP.  Hà Nội"
        }
      },
      "nationality": {
        "id": 77,
        "name": "Albanian"
      },
      "occupation": {
        "id": 1,
        "name": "Security"
      },
      "married": "single",
      "passport_no": "C123456789",
      "create_user": 9,
      "create_time": "05/10/2020 11:54:11",
      "create_by": "Minh Tran"
    },
    {
      "request_id": 2,
      "id": 2,
      "first_name": "A",
      "last_name": "Nguyen Van",
      "id_card_no": "112459781",
      "dob": "29/02/1999 00:00:00",
      "phone": "987654321",
      "email": "xyz@gmail.com",
      "user_name": "Abcxyz",
      "status": "lock",
      "address": {
        "street": "113 Abc xyz",
        "ward": {
          "id": 3,
          "name": " Tôn Đản"
        },
        "district": {
          "id": 1,
          "name": " Phường 123"
        },
        "province": {
          "id": 1,
          "name": "TP.  HCM"
        }
      },
      "nationality": {
        "id": 77,
        "name": "Albanian"
      },
      "occupation": {
        "id": 1,
        "name": "Security"
      },
      "married": "single",
      "passport_no": "C123456789",
      "create_user": 9,
      "create_time": "05/10/2020 11:54:11",
      "create_by": "Minh Tran"
    }
  ]
}

```

## Get Detail request profile API

### Request

- URI: /management/customer/{requestId}/temporary
- Method: GET

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer/1/temporary`

#### Path Parameter

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|requestId|Request's Identify|number|1|

### Response

#### Normal

- Status code:
  - 200 (OK)

##### Body

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|request_id|Request's ID|Number|1|
|id|Profile's ID|number|1|
|user_id|Account's ID|number|1|
|first_name|First name|string|A|
|last_name|Last name|string|Nguyen Van|
|id_card_no|ID card number|string|351111222|
|dob|Date of Birth|string|23/01/1989 00:00:00|
|gender|[Gender](#gender)|string|male|
|phone|Telephone number|string|0123456789|
|email|Email address|string|`sample.email@dummy.com`|
|status|Account status|string|UNLOCK|
|address|[Address](#address)|object||
|nationality|[Nationality](#nationality)|object||
|occupation|[Occupation](#occupation)|object||
|married|[Married status](#married-status)|string|single|
|passport_no|Passport number|string|C1234567|

#### Sample Response

```json
{
  "request_id": 27,
  "id": "1",
  "user_id": 27,
  "first_name": "A",
  "last_name": "Nguyen Van",
  "id_card_no": "351111222",
  "dob": "23/01/1989 00:00:00",
  "gender": "male",
  "phone": "0123456789",
  "email": "sample.email@dummy.com",
  "user_name": "vinh12344",
  "status": "unlock",
  "address": {
    "street": "14/12 Duong Ky Dong",
    "ward": {
      "id": 6603,
      "name": "Trà Bui"
    },
    "district": {
      "id": 515,
      "name": "Bắc Trà My"
    },
    "province": {
      "id": 49,
      "name": "Quảng Nam"
    }
  },
  "nationality": {
    "id": 265,
    "name": "Vietnamese"
  },
  "occupation": {
    "id": 1,
    "name": "Security"
  },
  "married": "single",
  "passport_no": "C123456789",
  "create_user": 9,
  "create_time": "05/10/2020 11:54:11",
  "create_by": "Minh Tran"
}
```

## Update Request Profile API

### Request

- URI: /management/customer/{request_id}/temporary
- Method: PUT

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer/1/temporary`

#### Body Parameter

|Required|Name|Description|Type|Example|
|:---|:---|:---|:---|:---|
|〇|id|Profile Id|number|1|
|〇| |User Id|number|1|
|〇|first_name|First Name|string|Tran|
|〇|last_name|Last Name|string|Quang|
|〇|id_card_no|ID Card No|string|123456|
|〇|dob|Dob|string|30/03/1994 00:00:00|
|〇|gender|[Gender](#gender)|string|male|
|〇|phone|Telephone number|string|012345|
|〇|email|Ward's ID|number|4|
|〇|street|Street's|string|Abc|
|〇|nationality|Nationality's ID|number|1|
|〇|occupation|Occupation's ID|number|1|
|〇|passport_no|Passport number|string|C1234567|
|〇|ward_id|Ward's ID|number|1|
||married|[Married status](#married-status)|string|single|


##### Sample Body

```json
{
  "id": 1,
  "first_name": "A",
  "last_name": "Nguyen Van",
  "id_card_no": "351111222",
  "dob": "23/01/1989 00:00:00",
  "gender": "male",
  "phone": "0123456789",
  "email": "sample.email@dummy.com",
  "street": "14/12 Duong Ky Dong",
  "ward_id": 4,
  "nationality": 1,
  "occupation": 1,
  "married": "single",
  "passport_no": "C123456789"
}
```

### Response

#### Normal

- Status code:
   - 200 (OK)

### Abnormal

- Status code:
  - 400 (BAD_REQUEST)
  - 404 (NOT_FOUND)

|Code|Message|Description|
|:----|:----|:----|
|first_name_required|Can not be empty.|The error occurs when `First Name` is empty.|
|first_name_maxlength|Length must be less than 60.|The error occurs when the length of `First Name` is exceeded.|
|first_name_invalid|Invalid Name format.|The error occurs when the value of `First Name` is invalid. (valid value is not contains special character and digit characters)|
|last_name_required|Can not be empty.|The error occurs when `Last Name` is empty.|
|last_name_maxlength|Length must be less than 60.|The error occurs when the length of `Last Name` is exceeded.|
|last_name_invalid|Invalid Name format.|The error occurs when the value of `Last Name` is invalid. (valid value is not contains special character and digit characters)|
|id_card_no|Can not be empty.|The error occurs when `ID card number` is empty.|
|id_card_maxlength|Length must be less than 24.|The error occurs when the length of `ID card number` is exceeded.|
|dob_required|Can not be empty.|The error occurs when `Date of Birth` is empty.|
|dob_invalid|Invalid Date format.|The error occurs when `Date of Birth` is invalid. (a valid `dob` must be formatted in `DD/MM/YYYY HH:MM:SS`)|
|gender_required|Can not be empty.|The error occurs when `Gender` is empty.|
|gender_invalid|Gender is invalid.|The error occurs when `Gender` is invalid. (valid Gender is defined at [Gender](#gender))|
|phone_required|Can not be empty.|The error occurs when `Phone` is empty.|
|phone_invalid|Invalid Phone Number format.|The error occurs when `Phone` is invalid. (a valid phone number must contains 10 or 11 digit)|
|email_required|Can not be empty.|The error occurs when `Email` is empty.|
|email_invalid|Invalid Email format.|The error occurs when `Email` is invalid. [Valid email address format](#valid-email-address-format)|
|street_required|Can not be empty.|The error occurs when `Address's Street` is empty.|
|street_maxlength|Length must be less than 60.|The error occurs when the length of `Address's Street` is exceeded.|
|ward_required|Can not be empty.|The error occurs when `Address's Ward` is empty.|
|nationality_required|Can not be empty.|The error occurs when `Nationality` is empty.|
|occupation_required|Can not be empty.|The error occurs when `Occupation` is empty.|
|passport_no_required|Can not be empty.|The error occurs when `Passport number` is empty.|
|passport_no_maxlength|Length must be less than 24.|The error occurs when the length of `Passport number` is exceeded.|

#### Sample Response

```json
{
  "errors": [
    {
      "code": "email_required",
      "message": "Can not be empty."
    },
    {
      "code": "phone_required",
      "message": "Can not be empty."
    }
  ]
}
```

## Update Customer's Status API

### Request

- URI: /management/customer/{id}/{status}
- Method: PATCH

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer/1/lock`

#### Path Parameter

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Customer's Identify|number|1|
|status|[Status](#status)|string|lock|

### Response

#### Normal

- Status code:
  - 200 (OK)

#### Abnomal

- Status code:
  - 400 (BAD_REQUEST)
  - 404 (NOT_FOUND)

|Code|Message|Description|
|:----|:----|:----|
|status_invalid|Status is invalid.|The error occurs when `Status` is invalid. (valid Status is defined at [Status](#status))|

#### Sample Response

```json
{
  "errors": [
    {
      "code": "status_invalid",
      "message": "Status is invalid."
    }
  ]
}
```

## Approver Request Edit Customer API

### Request

- URI:/management/customer/{id}/temporary/approve
- Method: PATCH

#### Path Parameter

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Request's Identify|number|1|

#### Sample Request

- URL: `https://127.0.0.1:8080//management/customer/{id}/temporary/approve`

### Response

#### Normal

- Status code:
  - 200 (OK)

#### Abnomal

- Status code:
  - 400 (BAD_REQUEST)
  - 404 (NOT_FOUND)
  - 406 (NOT_ACCEPTABLE)

## Reject Request Edit Customer API

### Request

- URI:/management/customer/{id}/temporary/reject
- Method: PATCH

#### Path Parameter

|Name|Description|Type|Example|
|:---|:---|:---|:---|
|id|Request's Identify|number|1|

#### Sample Request

- URL: `https://127.0.0.1:8080/management/customer/1/temporary/reject`

### Response

#### Normal

- Status code:
  - 200 (OK)

#### Abnomal

- Status code:
  - 404 (NOT_FOUND)
  - 400 (BAD_REQUEST)
  - 406 (NOT_ACCEPTABLE)

## Reference

### Married status

|Name|Description|
|:----|:----|
|single|Single|
|married|Married|
|remarried|Remarried|
|separated|Separated|
|divorced_widowed|Divorced or Widowed|

### Status

|Name|Description|
|:----|:----|
|lock|lock|
|unlock|unlock|

### Gender

|Name|Description|
|:----|:----|
|male|Male|
|female|Female|
|other|Undefined|

### Customer List Sort Key

|Name|Description|
|:----|:----|
|user_id|Customer identify|
|first_name|Customer first name|
|last_name|Customer last name|
|id_card_no|Customer id card number|
|dob|Date of birth|
|agency_id|Agency identify|
|agency_name|Agency name|

### Customer Temporary list Sort Key

|Name|Description|
|:----|:----|
|request_id|Request id|
|user_id|Customer identify|
|first_name|Customer first name|
|last_name|Customer last name|
|id_card_no|Customer id card number|
|dob|Date of birth|
|agency_id|Agency identify|
|agency_name|Agency name|

### Sort Direction

|Name|Description|
|:----|:----|
|asc|Ascending Order|
|desc|Descending Order|

### Valid email address format

A valid email address consists of an email prefix and an email domain, both in acceptable formats.

- The prefix appears to the left of the @ symbol.
- The domain appears to the right of the @ symbol.

For example, in the address example@mail.com, `example` is the email prefix, and `mail.com` is the email domain.

#### Acceptable email prefix formats

- Allowed characters: letters (a-z), numbers, underscores, periods, and dashes.
- An underscore, period, or dash must be followed by one or more letter or number.

|Invalid email prefixes|Valid email prefixes|
|:----|:----|
|abc-@mail.com|abc-d@mail.com|
|abc..def@mail.com|abc.def@mail.com|
|.abc@mail.com|abc@mail.com|
|abc#def@mail.com|abc_def@mail.com|

#### Acceptable email domain formats

- Allowed characters: letters, numbers, dashes.
- The last portion of the domain must be at least two characters, for example: .com, .org, .cc

|Invalid email domains|Valid email domains|
|:----|:----|
|abc.def@mail.c|abc.def@mail.cc|
|abc.def@mail#archive.com|abc.def@mail-archive.com|
|abc.def@mail|abc.def@mail.org|
|abc.def@mail..com|abc.def@mail.com|
