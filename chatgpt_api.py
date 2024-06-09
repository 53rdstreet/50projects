# Import the os package
import os

# Import the openai package
import openai

# From the IPython.display package, import display and Markdown
from IPython.display import display, Markdown

import pandas as pd

# initialize openai API key
openai.api_key = os.environ.get("MY_OPENAI_API_KEY")  #platform.openai.com
import numpy as np
# GPT-4, gpt-3.5-turbo: PermissionError: You are not allowed to generate embeddings from this model
res = openai.Embedding.create(
    input= "What is your favorite color?", engine="gpt-3.5-turbo") # text-embedding-ada-002
print(f"Embedding: {embedding}")
def chat(system, user_assistant):
    assert isinstance(system, str), "`system` should be a string"
    assert isinstance(user_assistant, list), "`user_assistant` should be a list"
    system_msg = [{"role": "system", "content": system}]
    user_assistant_msgs = [
        {"role": "assistant", "content": user_assistant[i]} if i % 2 else {"role": "user", "content": user_assistant[i]} 
        for i in range(len(user_assistant))
    ]
    msgs = system_msg + user_assistant_msgs
    response = openai.ChatCompletion.create(
        model="gpt-4", #gpt-3.5-turbo
        messages=msgs
    )
    status_code = response["choices"][0]["finish_reason"]
    assert status_code == "stop", f"The status code was {status_code}."
    return response["choices"][0]["message"]["content"]

response_fn_test = chat(
    "You are an expert database engineer/administrator.", 
    ["Please provide \
    a step-by-step guide on how to migrate data from a local PostgreSQL \
    database to a SQL Server on a network server using ODBC:."]
)
display(Markdown(response_fn_test))
