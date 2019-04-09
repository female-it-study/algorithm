def solution(phone_book):
    check_dict = dict()

    for number in sorted(phone_book):  # sorted(phone_book) is sorted by alphabet and length
        if len(check_dict) == 0:  # first number should be inserted into dict without checking
            check_dict[number] = 1
        else:
            if checkPrefix(check_dict.keys(), number):
                return False
            else:
                check_dict[number] = 1

    return True


# check if target number has previous numbers as prefix
def checkPrefix(prefixes, target_number):
    for prefix in sorted(prefixes):  # search from sorted prefix list
        if len(prefix) <= len(target_number):  # only compare when target number is longer than prefix
            return compare(prefix, target_number)
    return False


# compare two strings. prefix is always shorter than target string
def compare(prefix, target):
    for i in range(0, len(prefix)):
        if prefix[i] != target[i]:
            return False
    return True